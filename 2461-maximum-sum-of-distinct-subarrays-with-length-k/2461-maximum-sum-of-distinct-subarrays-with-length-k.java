class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        long maxSum = 0;
        long sum = 0;
        int left = 0; 

        for(int right = 0; right < n; right++){
            // if current element already exist in set
            // remove the elements from left until duplicate doesn't removed from the set
            while(hs.contains(nums[right])){
                sum -= nums[left];
                hs.remove(nums[left]);
                left++;
            }
            hs.add(nums[right]);
            sum += nums[right];

            // window == k
            // -> compare with maxSum
            // -> then remove the left element
            if(right - left + 1 >= k){
                maxSum = Math.max(maxSum, sum);
                sum -= nums[left];
                hs.remove(nums[left]);
                left++;
            }
        
        }

        return maxSum;

        
    }
}