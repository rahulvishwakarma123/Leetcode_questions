class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int s2 = newInterval[0];
        int e2 = newInterval[1];
        int n = intervals.length;
        boolean overlap = false;

        for(int i = 0; i < intervals.length; i++){
            // we can not modify the original input so that's why we don't do this.
            // int[] curr = intervals[i];
            int[] curr = new int[]{intervals[i][0], intervals[i][1]};
            int s1 = curr[0];   
            int e1 = curr[1];

            // overlap
            //         [4..........8]
            // [[1,2],[3,5],[6,7],[8,10],[12,16]]     
            //                              i
            //                      j
            //   [2...........7]
            // [[1,3],[4,5],[6,8]]
            //    i
            //                j
            if(e1 >= s2 && e2 >= s1){
                curr[0] = Math.min(s1, s2);
                int j = i;
                while(j + 1 < n && intervals[j+1][0] <= e2){
                    j++;
                }
                i = j;  // this step is important otherwise we add extra irrelevant intervals;
                curr[1] = Math.max(intervals[j][1], e2);
                res.add(curr);
                overlap = true;
            }
            // if new interval is not overlapping the lies in the middle of intervals.
            else if(!overlap && (e1 >= s2 && e2 < s1)){
                res.add(newInterval);
                res.add(curr);
                overlap = true;
            }
            else res.add(curr);
        }

        // new intervals lies in very last.
        if(!overlap){
            res.add(newInterval);
        }

        int[][] arr = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++){
            arr[i] = res.get(i);
        }

        return arr;
    }
}