class Solution {

    int[][] dp;

    public int strangePrinter(String s) {

        int n = s.length();

        dp = new int[n][n];

        for(int[] row : dp)
            Arrays.fill(row, -1);

        return solve(s, 0, n - 1);
    }

    private int solve(String s, int i, int j) {

        if(i > j)
            return 0;

        if(i == j)
            return 1;

        if(dp[i][j] != -1)
            return dp[i][j];

        // the wrost it can go for a string
        int ans = 1 + solve(s, i + 1, j);

        for(int k = i + 1; k <= j; k++) {

            // isme ham notice ye kar sakte hai ki first char se kth char ko match karte hai 
            // kyuki ye dono same hai ham kth char ko apane call me add nahi karte hai
            // kyuki kth char ki cost ith char me print hote time add ho jayegi.
            if(s.charAt(i) == s.charAt(k)) {

                ans = Math.min(
                    ans,
                    solve(s, i, k - 1)
                    + solve(s, k + 1, j)
                );
            }
        }

        return dp[i][j] = ans;
    }
}