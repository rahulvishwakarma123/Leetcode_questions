class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        else if(nums[0] != nums[1]) return nums[0];
        else if(nums[n-1] != nums[n-2]) return nums[n-1];

        int l = 1;
        int r = n-1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid + 1])
                return nums[mid];
            else if(mid % 2 == 0){
                if(nums[mid] == nums[mid-1]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
            else{
                if(nums[mid] == nums[mid-1]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}