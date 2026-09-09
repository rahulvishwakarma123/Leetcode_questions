class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        for(int i = 0; i < n; i++){
            if(i == 0) prefix[i] = nums[i];
            else prefix[i] = prefix[i-1] + nums[i];
        }

        for(int i = 0; i < n; i++){
            int leftSum = i == 0? 0: prefix[i-1];
            int rightSum = prefix[n-1] - prefix[i];

            if(leftSum == rightSum){
                return i;
            }
        }
        
        return -1;
    }
}