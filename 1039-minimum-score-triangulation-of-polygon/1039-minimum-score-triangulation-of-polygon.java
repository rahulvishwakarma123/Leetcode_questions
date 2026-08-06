class Solution {
    public int[][] dp;

    public int solve(int[] values, int i, int j){
        if(i + 1 == j) return 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int res = Integer.MAX_VALUE;
        for(int k = i+1; k < j; k++){
            int left = solve(values, i, k);
            int right = solve(values, k, j);
            int temp = left + values[i] * values[k] * values[j] + right;

            res = Math.min(temp, res);
        }

        dp[i][j] = res;
        return res;
    }
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        dp = new int[n+1][n+1];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return solve(values, 0, n-1);
    }
}