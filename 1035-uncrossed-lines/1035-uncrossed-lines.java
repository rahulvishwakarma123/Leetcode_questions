class Solution {
    public int[][] dp;
    public int lcs(int[] x, int[] y, int n, int m){
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                if(x[i-1] == y[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        dp = new int[n+1][m+1];
        return lcs(nums1, nums2, n, m);
    }
}