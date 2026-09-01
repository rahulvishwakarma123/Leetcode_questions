class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0; int right = n-1;
        int i = n-1;
        while(left <= right){
            if(Math.abs(nums[left]) < Math.abs(nums[right])){
                res[i] = nums[right] * nums[right];
                i--;
                right--; 
            }else{
                res[i] = nums[left] * nums[left];
                i--;
                left++;
            }
        }
        return res;
    }
}