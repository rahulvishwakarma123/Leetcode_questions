class Solution {
    // greedy approach of remove interval patterns
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        int arrow = 1;
        int end = points[0][1];
        for(int[] curr : points){
            int st = curr[0];
            // jo bhi interval pichala wala interval end hone se pahale start ho rahe hai wo ek hi arrow me burst ho jayenge
            if(st > end){
                arrow++;
                end = curr[1];
            }
        }
        return arrow;
    }
}