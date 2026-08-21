class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int res = 0; 
        int zeroCount = 0;
        for(int right = 0; right < n; right++){
            if(nums[right] == 0){
                zeroCount++;
            }
            // agar zero count window me 2 se jyada ho ja raha hai to window ko shrink karo jab tak zero count 1 nahi ho jata;
            while(zeroCount > 1){
                if(nums[left] == 0) zeroCount--;
                left++;
            }

            // ham total subarray element -1 hi le rahe hai kyuki ek element delete karna hai
            // total subarray element = right - left + 1;
            res = Math.max(res, right - left);
        }

        return res;
    }
}