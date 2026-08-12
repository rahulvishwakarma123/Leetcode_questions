class Solution {

    public int[][] dp;

    // think about the last balloon to solve this question.
    public int maxCoins(int[] nums) {

        // making the new array to add 1 to the left and right (for virtual boundry)
        int[] arr = new int[nums.length + 2];
        int n = arr.length;
        for(int i = 1; i <= nums.length; i++){
            arr[i] = nums[i-1];
        }
        
        // pahale aur last me 1 add karte hai taki index out of bound na aaye last ballon burst karne pe
        arr[0] = 1;
        arr[arr.length - 1] = 1;

        dp = new int[n+1][n+1];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        
        return solve(arr, 1, nums.length);
    }

    public int solve(int[] arr, int left, int right){
        if(left > right) return 0;

        if(dp[left][right] != -1) return dp[left][right];

        int ans = Integer.MIN_VALUE;

        for(int k = left; k <= right; k++){
            int left_part = solve(arr, left, k-1);
            int right_part = solve(arr, k+1, right);
            int current_cost = arr[left-1] * arr[k] * arr[right+1];

            int total_cost_for_current_interval = left_part + current_cost + right_part;

            ans = Math.max(total_cost_for_current_interval, ans);
        }

        dp[left][right] = ans;

        return ans;
        
    }
}