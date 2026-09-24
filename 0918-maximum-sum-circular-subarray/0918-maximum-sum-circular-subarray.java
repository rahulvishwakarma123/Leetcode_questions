class Solution {
    // circular subarray sum;
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int totalSum = nums[0];
        int minEndingHere  = nums[0];
        int maxEndingHere  = nums[0];
        int max = nums[0];
        int min = nums[0];

        for(int i = 1; i < n; i++){
            totalSum += nums[i];

            // for the circular array.
            minEndingHere = Math.min(nums[i], nums[i] + minEndingHere);
            min = Math.min(min, minEndingHere);

            // for the normal array
            maxEndingHere = Math.max(nums[i], nums[i] + maxEndingHere);
            max = Math.max(max, maxEndingHere);
        }

        if(totalSum - min == 0) return max;// means whole array is negative return max

        // max of cicular and normal
        return Math.max((totalSum - min), max); 
    }
}