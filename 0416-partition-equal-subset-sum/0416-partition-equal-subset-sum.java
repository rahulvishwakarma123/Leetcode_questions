class Solution {
    public boolean solve(int[] nums, int target, int n, Boolean[][] dp){
        if(n == 0){
            if(target == 0){
                return true;
            }
            return false;
        }

        if(dp[n][target] != null){
            return dp[n][target];
        }

        if(nums[n - 1] <= target){
            dp[n][target] = solve(nums, target - nums[n-1], n-1, dp) || solve(nums, target, n-1,dp);
            return dp[n][target];
        }
        else {
            dp[n][target] = solve(nums, target, n-1,dp);
            return dp[n][target];
        }

        // return dp[n][target];
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int totalSum = 0;
        for(int i = 0; i < n; i++){
            totalSum += nums[i];
        }
        
        // if total sum = odd then can't divide into 2 equal numbers.
        if(totalSum % 2 != 0) return false;

        int target = totalSum / 2;

        Boolean[][] dp = new Boolean[n+1][target + 1];

        return solve(nums, target, n, dp);
    }
}