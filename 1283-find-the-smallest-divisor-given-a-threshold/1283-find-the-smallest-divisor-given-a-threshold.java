class Solution {
    // binary search on answer
    public boolean validDivisor(int[] nums, int threshold, int x){
        for(int num : nums){
                        // adding x-1 for cieling value;
            threshold -= (num + x - 1) / x;
            if(threshold < 0) return false;
        }
        return true;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int lowestDiv = 1;
        int largestDiv = 0;
        for(int x : nums){
            largestDiv = Math.max(largestDiv, x);
        }
        int validMinDiv = -1;
        while(lowestDiv <= largestDiv){
            int mid = lowestDiv + (largestDiv - lowestDiv) / 2;
            if(validDivisor(nums, threshold, mid)){
                // if found valid ans, store in and search for min
                 validMinDiv = mid;
                 largestDiv = mid - 1;
            }
            else lowestDiv = mid + 1;
        }
        return validMinDiv;
    }
}