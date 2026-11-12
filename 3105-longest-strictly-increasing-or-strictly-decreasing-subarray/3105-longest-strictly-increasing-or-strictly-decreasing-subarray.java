class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int maxInc = 0;
        int maxDec = 0;
        int inc = 0;
        int dec = 0;
        int i = 0;
        while(i < n){
            while(i+1 < n && nums[i] == nums[i+1]){
                i++;
            }
            int j = i+1;
            while(j < n && nums[j] > nums[j-1]){
                inc = j-i+1;
                maxInc = Math.max(inc, maxInc);
                j++;
            }
            i = j-1;
            while(j < n && nums[j] < nums[j-1]){
                dec = j-i+1;
                maxDec = Math.max(dec, maxDec);
                j++;
            }
            i = j-1;
            if(j >= n){
                break;
            }
        }

        int res = Math.max(maxInc, maxDec);

        return res == 0? 1: res;
    }
}