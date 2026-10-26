class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int[] trip: trips){
            min = Math.min(trip[1], min);
            max = Math.max(trip[2], max);
        }
        int[] arr = new int[max-min+1];

        for(int[] trip: trips){
            int st = trip[1];
            int end = trip[2];
            arr[st - min] += trip[0];
            arr[end - min] -= trip[0];
        }
        int ans = arr[0];
        for(int i = 1; i < arr.length; i++){
            arr[i] += arr[i-1];
            System.out.print(arr[i] + ",");
            ans = Math.max(ans, arr[i]);
        }
        if(ans <= capacity){
            return true;
        }
        return false;
    }
}