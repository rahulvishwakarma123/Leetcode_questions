class Solution {
    public int countSquares(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int[][] dp = new int[n+1][m+1];
        int count = 0;
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                if(arr[i-1][j-1] == 0) dp[i][j] = 0;
                else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
                count += dp[i][j];
            }
        }

        return count;

    }
}