class Solution {

    // take and skip normal dp + memoization approach.
    public HashMap<String, Long> dp;
    public long maxAlternatingSum(int[] nums) {
        dp = new HashMap<>();
        return solve(nums, 1, 0);
    }
    public long solve(int[] nums, int add, int i){
        if(i == nums.length) return 0;

        String key = String.valueOf(i) + '_' + String.valueOf(add);

        if(dp.containsKey(key)){
            return dp.get(key);
        }

        // not take
        long skip = solve(nums, add, i+1);

        int val = nums[i];
        if(add == 0) val = -val;

        //take
        long take = solve(nums, Math.abs(add - 1), i+1) + val;


        dp.put(key, Math.max(take, skip));
        return Math.max(take, skip);
    }
}