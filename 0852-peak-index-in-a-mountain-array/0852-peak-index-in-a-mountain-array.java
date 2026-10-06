class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n- 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int prev = mid -1 < 0 ? Integer.MIN_VALUE : nums[mid -1];
            int next = mid +1 >= n ? Integer.MAX_VALUE : nums[mid +1];
            if(nums[mid] > prev && nums[mid] > next){
                return mid;
            }
            else if(nums[mid] < next){
                l = mid + 1;
            }
            else r = mid -1;
        }
        return -1;
    }
}