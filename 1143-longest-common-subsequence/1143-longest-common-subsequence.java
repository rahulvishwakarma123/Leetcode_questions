class Solution {

    public int[][] dp;
    public int lcsTab(String x, String y, int n, int m){

        // initialization
        for(int i = 0; i < n+1; i++){
            dp[i][0] = 0;
        }
        for(int j = 1; j < m+1; j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                char a = x.charAt(i-1);
                char b = y.charAt(j-1);

                if(a == b){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[n][m];
    }

    // memoization code
    private void intializeDP(){
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
    }
    public int lcsMemo(String x, String y, int n, int m){
        if(n == 0 || m == 0){
            return 0;
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        if(x.charAt(n-1) == y.charAt(m-1)){
            dp[n][m] = 1 + lcsMemo(x, y, n-1, m-1);
        }else {
            int choise1 = lcsMemo(x, y, n-1, m);
            int choise2 = lcsMemo(x, y, n, m-1);

            dp[n][m] = Math.max(choise1, choise2);
        }

        return dp[n][m];
    }
    public int longestCommonSubsequence(String x, String y) {
        int n = x.length();
        int m = y.length();

        dp = new int[n+1][m+1];

        // intializeDP();
        // return lcsMemo(x, y, n, m);

        return lcsTab(x, y, n, m);
    }
}