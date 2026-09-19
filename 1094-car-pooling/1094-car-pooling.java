class Solution {

    // differece array approach 
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        
        // find the largest destIndex
        int largDestIndex = 0;
        for(int i = 0; i < n; i++){
            largDestIndex = Math.max(largDestIndex, trips[i][2]);
        }

        int[] diff = new int[largDestIndex + 1];

        for(int i = 0; i < n; i++){
            int passenger = trips[i][0];
            int src = trips[i][1];
            int dest = trips[i][2];


            // adding to start
            diff[src] += passenger;

            // removing from end;
            diff[dest] -= passenger;
        }

        // calculating the prefix array with diff
        for(int i = 0; i < diff.length; i++){
            if(i != 0) {diff[i] = diff[i-1] + diff[i];}
            if(diff[i] > capacity) return false;
        }

        return true;
    }

    // TC = O(diff.length)
}