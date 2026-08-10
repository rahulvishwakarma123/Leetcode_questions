class Solution {
    public int maximalSquare(char[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return 0;
        }
        
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] dp = new int[n][m];
        int ans = 0;
        
        // Initialize first column
        for(int i = 0; i < n; i++){
            if(mat[i][0] == '1') {
                dp[i][0] = 1;
                ans = Math.max(ans, dp[i][0]);
            }
        }
        
        // Initialize first row
        for(int j = 0; j < m; j++){
            if(mat[0][j] == '1') {
                dp[0][j] = 1;
                ans = Math.max(ans, dp[0][j]);
            }
        }
        
        // Fill the rest of the DP table
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(mat[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    ans = Math.max(dp[i][j], ans);
                }
                // If mat[i][j] == '0', dp[i][j] remains 0 (default)
            }
        }
        
        return ans * ans;
    }
}