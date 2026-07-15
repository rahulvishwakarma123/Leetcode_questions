class Solution {
    public int totalSum = 0;
    public int solve(int[] nums, int target, int sum, int n, int[][] dp){
        if(n == 0){
            if(target == sum){
                return 1;
            }else{
                return 0;
            }
        }

        // reuturn if already calculated
        if(dp[n][sum + totalSum] != -1){
            return dp[n][sum + totalSum];
        }

        // 2 choises are there - first add choise and second subtract choise
        dp[n][sum + totalSum] = solve(nums, target, sum + nums[n-1], n-1, dp) + solve(nums, target, sum - nums[n-1], n-1, dp);
        return dp[n][sum + totalSum];
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        // pahale total sum calculate kiya
        for(int num : nums){
            totalSum +=  num;
        }

        // fir dp array banaya [n+1][2totalSum + 1] => 2totalsum because hamara sum negative me bhi ja sakta hai isliye jth index me sab jagah totalSum add kar denge jisse extreme negative sum 0 ho jaye;
        // if sum = 5;
        // then negative sum = -5;
        // and positive sum = 5 hoga
        // isi wajah se sab jagah second index me totalSum add hua hai -> index ko range me rakhane ke liye
        int[][] dp = new int[n+1][totalSum + totalSum + 1];

        // initialization;
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= 2*totalSum; j++){
                dp[i][j] = -1;
            }
        }

        return solve(nums, target, 0, n, dp);
    }
}