class Solution {
    // kadan's - minimum absolute subarray sum;
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        int res = Math.max(Math.abs(min), Math.abs(max));
        for(int i = 1; i < n; i++){
            max = Math.max(nums[i], max+nums[i]);
            min = Math.min(nums[i], min+nums[i]);

            res = Math.max(res, Math.max(Math.abs(min), Math.abs(max)));
        }
        return res;
    }
}