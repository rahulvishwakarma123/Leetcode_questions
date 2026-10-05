class Solution {

    // standard binary search function
    public int binaryLeft(int[] nums, int target){
        int index = -1;
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int curr = nums[mid];

            if(curr == target){
                index = mid;
                // modification : found target!, now search in left 
                r = mid - 1; 
            }
            else if(curr < target){
                l = mid + 1;
            }
            else r = mid - 1;
        }
        return index;
    }
    public int binaryRight(int[] nums, int target){
        int index = -1;
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int curr = nums[mid];

            if(curr == target){
                index = mid;
                // modification : found target!, now search in right 
                l = mid + 1; 
            }
            else if(curr < target){
                l = mid + 1;
            }
            else r = mid - 1;
        }
        return index;
    }
    public int[] searchRange(int[] nums, int target) {
        int left = binaryLeft(nums, target);
        int right = binaryRight(nums, target);
        return new int[]{left, right};
    }
}