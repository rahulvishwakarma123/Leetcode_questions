class Solution {
    // same code as Painter's partition problem and book allocation problem
    public boolean isSumPossible(int[] nums, int mid, int k){
        int sum = 0;
        int partitionNeed = 1;
        for(int num : nums){
            if(sum + num > mid){
                partitionNeed++;
                sum = 0;
            }
            sum += num;
            if(partitionNeed > k){
                return false;
            }
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int max = 0;
        for(int num: nums){
            // maximum is sum of all elements (if k == 1)
            max += num;
            // minimum time is Max of all elements (if k == nums.length - 1)
            low = Math.max(low, num); 
        }
        int ans = -1;
        while(low <= max){
            int mid = low + (max - low)/ 2;
            if(isSumPossible(nums, mid, k)){
                ans = mid;
                max = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
}