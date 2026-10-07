class Solution {
    public boolean canEat(int[] piles, int h, int eatingSpeed){
        for(int banana : piles){
            h -= (banana + eatingSpeed - 1) / eatingSpeed;
            if(h < 0){
                // all the time has spent
                return false;
            }
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int hours) {
        int l = 1; // lowest banana she can eat in an hour
        int h = Integer.MIN_VALUE; // maximum she can eat
        for(int banana : piles){
            h = Math.max(banana, h);
        }
        int ans = 1;
        // binary search on answer
        while(l <= h){
            int mid = l + (h - l) / 2;
            if(canEat(piles, hours, mid)){
                // perfect spot so return it
                if(mid == hours) return mid; 
                // if she can eat in mid so she can also eat in greater than mid hours
                // so we try to find more slow speed
                ans = mid;
                h = mid - 1;
            }
            else l = mid + 1;
        }
        return ans;
    }

}