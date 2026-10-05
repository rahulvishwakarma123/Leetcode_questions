class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int st = 0;
        int end = n-1;
        while(st <= end){
            int mid = st + (end - st) / 2;
            int prev = mid - 1 < 0 ? Integer.MIN_VALUE : nums[mid - 1];
            int next = mid + 1 >= n ? Integer.MIN_VALUE : nums[mid + 1];

            if(nums[mid] > prev && nums[mid] > next){
                return mid;
            }
            else if(nums[mid] < next){
                st = mid + 1;
            }
            else end = mid - 1;
        }
        return 0;
    }
}