class Solution {
    // solved using binary search;
    // we might say binary search on ans;
    public int mySqrt(int x) {
        int left = 1; 
        int right = x;
        while(left <= right){
            int mid = left + ((right - left) / 2);
            long square = ((long)mid * (long)mid);
            if(square == x) return mid;
            else if(square < x) left = mid + 1;
            else right = mid - 1;
        }

        return right;
    }
}