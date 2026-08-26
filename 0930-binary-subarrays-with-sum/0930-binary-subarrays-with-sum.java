class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        if(goal == 0) return atMost(nums, goal);
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
    public int atMost(int[] nums, int goal){
        int n = nums.length, i = 0, res = 0, sum = 0;
        for(int j = 0; j < n; j++){
            sum += nums[j];
            while(i < n && sum > goal){
                sum -= nums[i];
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
}