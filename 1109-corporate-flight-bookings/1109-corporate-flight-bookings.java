class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];

        for(int[] booking: bookings){
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];

            res[first - 1] += seats;
            if(last < n){
                res[last] -= seats;
            }
        }

        for(int i = 1; i < n; i++){
            res[i] += res[i-1];
        }
        return res;
    }
}