class Solution {
    // mistake : not taking greedy approach, I had to take the intervals which ended first.
    // ans sorting the intervals on the basis of starting time
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) ->{
            return Integer.compare(a[1], b[1]);
        });
        int arrow = 0;
        int i = 0;
        int j = 0;
        while(i < points.length){
            j = i+1;
            while(j < points.length && (points[i][1] >= points[j][0] && points[j][1] >= points[i][0])){
                j++;
            }
            arrow++;
            i = j;
        }
        return arrow;
    }
}