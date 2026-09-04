class Solution {
    public int removeDuplicates(int[] nums) {
        int write = 0;
        int read = 0;
        int n = nums.length;
        while(read < n){
            while(read < n && nums[read] == nums[write]){
                read++;
            }
            if(read == n) break;
            write++;
            nums[write] = nums[read];
        }
        return write+1;
    }
}