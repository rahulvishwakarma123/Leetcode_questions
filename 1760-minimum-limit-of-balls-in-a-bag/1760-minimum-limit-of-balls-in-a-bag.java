class Solution {

    public boolean validPanalty(int[] nums, int maxOperations, int panalty){
        for(int num: nums){
            maxOperations -= num/panalty;

            //if number is perfectly divisible by panalty then it take 1 less operation
            if(num % panalty == 0){
                maxOperations += 1;
            }
            if(maxOperations < 0) {
                return false;
            }
        }
        return true;
    }
    
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int num : nums){
            high = Math.max(num, high);
        }
        int maxPanalty = -1;
        // binary search on ans code
        while(low <= high){
            int panalty = low + (high - low) / 2;
            if(validPanalty(nums, maxOperations, panalty)){
                maxPanalty = panalty;
                high = panalty - 1;
            }else{
                low = panalty + 1;
            }
        }
        return maxPanalty;
    }
}