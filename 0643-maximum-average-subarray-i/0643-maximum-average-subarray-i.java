class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double avg = 0;
        int n = nums.length;
        double windowSum = 0;
        
        // first window
        for(int i = 0; i < k; i++){
            windowSum += nums[i];
        }
        avg = (double)(windowSum / (double) k);

        // slide the window
        for(int i = k; i < n; i++){
            windowSum += nums[i] - nums[i-k];
            avg = Math.max((double)(windowSum/ (double) k), avg);
        }
        return avg;
    }
}