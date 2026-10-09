class Solution {
    public boolean isValidDay(int[] bloomDay, int m, int k, int mid){
        int consecutiveFlowers = 0;
        int totalBouquets = 0;

        for(int day : bloomDay){
            consecutiveFlowers++;
            // if blooming day is greater than current day
            if(day > mid){
                consecutiveFlowers = 0;
            }
            if(consecutiveFlowers >= k){
                totalBouquets++;
                consecutiveFlowers = 0;
            }
            if(totalBouquets >= m){
                return true;
            }
        }
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int low = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int day : bloomDay){
            max = Math.max(max, day);
            low = Math.min(low, day);
        }
        int ans = -1;
        while(low <= max){
            int mid = low + (max - low)/ 2;
            if(isValidDay(bloomDay, m, k, mid)){
                ans = mid;
                max = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
}