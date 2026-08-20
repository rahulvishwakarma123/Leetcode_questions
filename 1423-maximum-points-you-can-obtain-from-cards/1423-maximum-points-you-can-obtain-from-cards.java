class Solution {
    // because we have to take k card so this is the problem of sliding window.
    // second clue of sliding window is 1 <= k <= cardPoints.length
    public int maxScore(int[] cp, int k) { //cp is cardPoints
        int n = cp.length;
        int total = 0;

        // first adding the k elements to the sum
        for(int i = 0; i < k; i++){
            total += cp[i];
        }
        int maxSum = total;
        // adding a element from the right end the remove a element from the last of left.
        for(int i = k-1, j = n-1; i >= 0; j--, i--){
            total += cp[j] - cp[i];
            maxSum = Math.max(total, maxSum);
        }

        return maxSum;
    }
}