class Solution {
    public int[][][] dp;
    public int fx(int st, int end, int k, int[] boxes){
        if(st > end) return 0;
        // if(st == end) return 0;

        if(dp[st][end][k] != 0) return dp[st][end][k];

        int originalSt = st;
        int originalK = k;
        
        // compress consecutive same color boxes
        while(st+1 <= end && boxes[st] == boxes[st+1]){
            st++; k++;
        }


        // option 1 : remove the current group immediatly
        int ans = (k+1) * (k+1) + fx(st+1, end, 0, boxes);

        // option 2 : merge with same colored boxes later
        for(int mid = st+1; mid<= end; mid++){
            if(boxes[st] == boxes[mid]){
                ans = Math.max(ans, 
                                fx(st+1, mid-1, 0, boxes) + fx(mid, end, k+1, boxes));
                                // in second call we are doing k+1 becase after removing the middile part we have to recall that we had the same color box before in the left side.
            }
        }

        dp[originalSt][end][originalK] = ans;
        return ans;
    }
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        dp = new int[n+1][n+1][n+1];
        return fx(0, boxes.length -1, 0, boxes);
    }
}