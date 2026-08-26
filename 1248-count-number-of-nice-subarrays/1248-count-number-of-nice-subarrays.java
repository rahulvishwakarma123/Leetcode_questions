class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);  // -> key point for this problem
    }

    // this function find number of subarrays which contains <= k odd numbers
    public int atMost(int[] nums, int k){
        int n = nums.length, oddCount = 0, left = 0, res = 0;

        for(int right = 0; right < n; right++){
            oddCount += (nums[right] % 2); // odd -> 1, even -> 0;

            while(oddCount > k){
                oddCount -= (nums[left] % 2);
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}