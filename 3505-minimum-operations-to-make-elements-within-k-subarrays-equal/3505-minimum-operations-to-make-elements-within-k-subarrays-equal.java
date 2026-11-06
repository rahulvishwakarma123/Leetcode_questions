
import java.util.*;

class Solution {
    public int x, k, n;
    public long[] cost;
    public long[][] dp;

    // calculating the cost of every window
    public void calculateCost(int[] nums) {

        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        int i = 0;
        int j = 0;

        long leftSum = 0, rightSum = 0;
        int leftSize = 0, rightSize = 0;

        while (j < n) {

            int val = nums[j];

            // putting the value in correct TreeMap
            if (leftSize <= rightSize) {
                left.put(val, left.getOrDefault(val, 0) + 1);
                leftSum += val;
                leftSize++;
            } else {
                right.put(val, right.getOrDefault(val, 0) + 1);
                rightSum += val;
                rightSize++;
            }

            // balancing the TreeMaps
            if (!right.isEmpty() && left.lastKey() > right.firstKey()) {

                int leftMax = left.lastKey();
                int rightMin = right.firstKey();

                // removing leftMax from left
                left.put(leftMax, left.get(leftMax) - 1);
                if (left.get(leftMax) == 0) {
                    left.remove(leftMax);
                }

                // putting leftMax in right
                right.put(leftMax, right.getOrDefault(leftMax, 0) + 1);

                // removing rightMin from right
                right.put(rightMin, right.get(rightMin) - 1);
                if (right.get(rightMin) == 0) {
                    right.remove(rightMin);
                }

                // putting rightMin in left
                left.put(rightMin, left.getOrDefault(rightMin, 0) + 1);

                // updating sums
                leftSum += -leftMax + rightMin;
                rightSum += -rightMin + leftMax;
            }

            // calculating cost if window size is x
            if (j - i + 1 == x) {

                int median = left.lastKey();

                cost[i] =
                    (long) median * leftSize - leftSum
                    + rightSum - (long) median * rightSize;

                // shifting window right
                int valOnI = nums[i];
                i++;

                if (left.containsKey(valOnI)) {

                    left.put(valOnI, left.get(valOnI) - 1);

                    if (left.get(valOnI) == 0) {
                        left.remove(valOnI);
                    }

                    leftSum -= valOnI;
                    leftSize--;

                } else {

                    right.put(valOnI, right.get(valOnI) - 1);

                    if (right.get(valOnI) == 0) {
                        right.remove(valOnI);
                    }

                    rightSum -= valOnI;
                    rightSize--;
                }

                // restore partition sizes and ordering
                int target = (x + 1) / 2;

                while (leftSize > target) {

                    int v = left.lastKey();

                    left.put(v, left.get(v) - 1);
                    if (left.get(v) == 0) {
                        left.remove(v);
                    }

                    leftSum -= v;
                    leftSize--;

                    right.put(v, right.getOrDefault(v, 0) + 1);
                    rightSum += v;
                    rightSize++;
                }

                while (leftSize < target) {

                    int v = right.firstKey();

                    right.put(v, right.get(v) - 1);
                    if (right.get(v) == 0) {
                        right.remove(v);
                    }

                    rightSum -= v;
                    rightSize--;

                    left.put(v, left.getOrDefault(v, 0) + 1);
                    leftSum += v;
                    leftSize++;
                }
            }

            j++;
        }
    }

    public long solve(int i, int count) {

        if (count == k) {
            return 0;
        }

        // Minimum elements required to select remaining windows
        int elementsNeededNow = (k - count) * x;
        int elementsWeHave = n - i;

        if (elementsWeHave < elementsNeededNow) {
            return Long.MAX_VALUE / 4;
        }

        if (i > n - x) {
            return Long.MAX_VALUE / 4;
        }

        if (dp[i][count] != -1) {
            return dp[i][count];
        }

        // Take current window
        long take = cost[i] + solve(i + x, count + 1);

        // Skip current window
        long skip = solve(i + 1, count);

        dp[i][count] = Math.min(take, skip);

        return dp[i][count];
    }

    public long minOperations(int[] nums, int x, int k) {

        this.n = nums.length;
        this.x = x;
        this.k = k;

        cost = new long[n - x + 1];

        dp = new long[n + 1][k + 1];

        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        calculateCost(nums);

        return solve(0, 0);
    }
}
