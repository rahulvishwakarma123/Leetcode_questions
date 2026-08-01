class Solution {
     public int[][] dp;
    
    public int solve(int egg, int floor) {
        if (floor <= 1) return floor;
        if (egg == 1) return floor;
        if (egg == 0) return 0;
        
        if (dp[egg][floor] != -1) return dp[egg][floor];
        
        int res = Integer.MAX_VALUE;
        int low = 1, high = floor;
        
        // Binary search for optimal floor
        while (low <= high) {
            int mid = (low + high) / 2;
            
            int egg_break = solve(egg - 1, mid - 1);
            int not_break = solve(egg, floor - mid);
            int worst = Math.max(egg_break, not_break) + 1;
            
            res = Math.min(res, worst);
            
            // If egg_break > not_break, we need to go lower
            if (egg_break > not_break) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        dp[egg][floor] = res;
        return res;
    }
    public int superEggDrop(int k, int n) {
        dp = new int[k + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(k, n);
    }
}