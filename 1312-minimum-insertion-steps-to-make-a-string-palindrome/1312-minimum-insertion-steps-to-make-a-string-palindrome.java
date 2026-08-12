class Solution {
    public int[][] dp;
    public int minInsertions(String s) {
        String rev = new StringBuilder(s).reverse().toString();

        int n = s.length();

        dp = new int[n+1][n+1];

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < n+1; j++){
                if(s.charAt(i-1) == rev.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        int lcs_length = dp[n][n];

        return s.length() - lcs_length;
    }
}