class Solution {
    public boolean validShipCapacity(int[] weights, int days, int shipCapacity){
        int curr = 0;
        int daysNeeded = 1;
        for(int weight: weights){
            // first check the condition
            if(weight + curr > shipCapacity){
                daysNeeded++;
                curr = 0;
            }
            // then increase the capacity
            curr += weight;
            if(daysNeeded > days) return false;
        }
        return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for(int weight: weights){
            low = Math.max(low, weight);
            high += weight;
        }
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(validShipCapacity(weights, days, mid)){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
}