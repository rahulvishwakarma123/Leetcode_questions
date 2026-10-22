class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n < 2) {
            return 0;
        }
        Arrays.sort(intervals, (a,b) -> {
            if(a[1] != b[1]){
                return Integer.compare(a[1], b[1]);
            }
            else {
                return Integer.compare(a[0], b[0]);
            }
        });

        int[] last = intervals[0];
        int count = 0;
        int i = 1;
        while(i < intervals.length){
            int[] curr = intervals[i];
            // overlap
            if(last[1] > curr[0] && curr[1] > last[0]){
                        // a...................b     -> last
                // c................d  -> curr
                if(last[1] > curr[1]){
                    last = intervals[i];
                    i++;
                    count++;
                }
                // a...................b     -> last
                            // c................d  -> curr
                else{
                    i++;
                    count++;
                }
            }
            // non - overlap
            else{
                last = intervals[i];
                i++;
            }
        }

        return count;
        
    }
}