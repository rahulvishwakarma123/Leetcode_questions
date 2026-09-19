class Solution {

    // differece array approach 
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;

        // find the largest destIndex
        int largDestIndex = 0;
        for (int i = 0; i < n; i++) {
            largDestIndex = Math.max(largDestIndex, trips[i][2]);
        }

        int[] diff = new int[largDestIndex + 1];

        for (int i = 0; i < n; i++) {
            int passenger = trips[i][0];
            int src = trips[i][1];
            int dest = trips[i][2];

            // adding to start
            diff[src] += passenger;

            // removing from end;
            diff[dest] -= passenger;
        }

        // calculating the prefix array with diff
        int currPassengers = 0;

        for (int x : diff) {
            currPassengers += x;

            if (currPassengers > capacity)
                return false;
        }

        return true;
    }

    // TC = O(max(diff.length, n))
}