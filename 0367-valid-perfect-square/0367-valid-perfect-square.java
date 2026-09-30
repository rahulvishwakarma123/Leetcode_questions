class Solution {

    // common binary search
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        int left = 1;
        int right = num / 2;
        while(left <= right){
            int mid = left + (right - left) / 2;
            long sqr = (long)mid * (long)mid;
            if(sqr == num) return true;
            else if(sqr < num) left = mid+ 1;
            else right = mid - 1;
        }
        return false;
    }
}