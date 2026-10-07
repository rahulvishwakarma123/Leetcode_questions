class Solution {
    public boolean validTrip(int[] times, long totalTrips, long currTime){
        for(int time : times){
            if(currTime >= time){
                totalTrips -= (currTime / time);
            }
            if(totalTrips <= 0) return true;
        }
        return false;
        
    } 
    public long minimumTime(int[] times, int totalTrips) {
        // take maximum and minimum possible time
        long low = 1;
        long high = Integer.MAX_VALUE;
        for(int time : times){
            // high = Math.max(time, high);
            high = Math.min(time, high); // this is much tighter bound
        }
        high = high * (long)totalTrips;
        long ans = -1;
        while(low <= high){
            long mid = low + (high - low)/ 2;
            // if a valid ans found, try make it more smaller
            if(validTrip(times, (long)totalTrips, mid)){
                ans = mid;
                high = mid - 1;
            }else low = mid + 1;
        }
        return ans;
    }
}