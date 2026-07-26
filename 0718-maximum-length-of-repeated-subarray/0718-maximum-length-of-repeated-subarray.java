class Solution {
    
    // this question is variation of longest common substring -> notes in the ipad
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[][] dp = new int[n+1][m+1];

        int res = 0;
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){

                // if elements are same then add one to the previous value
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }

                // if sequence break then make it zero
                else {
                    dp[i][j] = 0;
                }
                res = Math.max(dp[i][j], res);
            }
        }

        return res;

        
    }
}