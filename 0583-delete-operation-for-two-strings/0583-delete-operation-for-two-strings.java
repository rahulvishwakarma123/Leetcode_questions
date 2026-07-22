class Solution {
    public int[][] dp;

    // normal longest common subsequence code.
    public int lcs(String x, String y, int n, int m){
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                if(x.charAt(i - 1) == y.charAt(j -1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }


    public int minDistance(String x, String y) {
        int n = x.length();
        int m = y.length();

        dp = new int[n+1][m+1];
        
        // dono me jo same letters ke sequences hai unko alag kar ke jo match nahi kar rahe hai unhe reduce ya delete kar de rahe hai 
        int lcs_length = lcs(x, y, n, m);

        return (n - lcs_length + m - lcs_length);
    }
}