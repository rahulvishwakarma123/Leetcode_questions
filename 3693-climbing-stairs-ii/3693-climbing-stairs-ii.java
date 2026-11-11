class Solution {
    public int[] cost;
    public int n;
    public int[] dp;

    public int solve(int i){
        if(i >= n){
            return 0;
        }

        if(dp[i] != -1) return dp[i];

        int j = i+1;
        int res = 0;
        if(j <= cost.length){
            res = cost[j-1] + 1 + solve(j);
        }

        j = i + 2;
        if(j <= cost.length){
            res = Math.min(res, cost[j-1] + 4 + solve(j));
        }

        j = i + 3;
        if(j <= cost.length){
            res = Math.min(res, cost[j-1] + 9 + solve(j));
        }

        dp[i] = res;
        
        return res;


    }
    public int climbStairs(int n, int[] cost) {
        this.n = n;
        this.cost = cost;
        dp = new int[n+1];

        Arrays.fill(dp, -1);

        return solve(0);
    }
}