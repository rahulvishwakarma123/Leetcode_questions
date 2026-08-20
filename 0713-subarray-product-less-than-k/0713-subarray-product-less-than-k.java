class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int n = nums.length, left = 0, right = 0, prod = 1, ans = 0;
        while(right < n){
            prod *= nums[right];
            // if prod > k then remove the element from the left to reduce the product
            while(prod >= k){
                prod /= nums[left];
                left++;
            }

            // naya wala element kitne aur subarrays banayega
            ans += right - left + 1;
            right++;
        }

        return ans;
    }

}