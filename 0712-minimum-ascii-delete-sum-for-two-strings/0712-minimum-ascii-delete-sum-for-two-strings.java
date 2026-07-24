class Solution {
    public int[][] dp;
    public void make_table(String x, String y, int n, int m){
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    dp[i][j] = (int) x.charAt(i-1) + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
    }

    public int calculate_sum(String x, String y, int sum){
        int n = x.length();
        int m = y.length();

        for(int i = 0; i < n; i++){
            char c = x.charAt(i);
            sum += (int) c;
        }
         for(int i = 0; i < m; i++){
            char c = y.charAt(i);
            sum += (int) c;
        }

        return sum;
    }
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        dp = new int[n+1][m+1];


        // first make the lcs table from the lcs tabulation code
        make_table(s1, s2, n, m);

        // then traverse on the table and calculate the sum
        int sum = calculate_sum(s1, s2, 0);
        int res = sum - (2*dp[n][m]);
        return res;
    }
}