class Solution {
    // valid triangle : sum of smaller two sides is strictly greater than the third side.
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
       int res = 0;
       int n = nums.length;
       for(int k = n-1; k >= 2; k--){
            int i = 0;
            int j = k-1;
            while(i < j){
                if(nums[i] + nums[j] > nums[k]){
                    res += j-i;
                    j--;
                }else{
                    i++;
                }
            }
       } 
       return res;
    }  
}