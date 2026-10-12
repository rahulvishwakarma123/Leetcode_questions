class Solution {
    public boolean covered(int[][] intervals, int i, int j){
        int[] prev = intervals[i];
        int[] curr = intervals[j];
              //   c          a          b           d
        return (prev[0] <= curr[0] && curr[1] <= prev[1]);
    }
    public int removeCoveredIntervals(int[][] intervals) {
        // algo: 
            // if interval length is 1 return 1
            // sort intervals by starting position
            // iterate intervals
                // while covered
                //     ans++
                //     j++
                // i = j;
                // j++
            // return intervals.length - ans;
        int n = intervals.length;
        if(n <= 1) return 1;
        Arrays.sort(intervals, (a, b) ->{
            if(a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            else
                return Integer.compare(b[1], a[1]);
        });
        for(int k = 0; k < n; k++){
            System.out.print("[" + intervals[k][0] + "][" + intervals[k][1] + "],");
        }
        int i = 0;
        int j = 1;
        int ans = 0;
        while(j < n){
            while(j < n && covered(intervals, i, j)){
                j++;
                ans++;
            }
            i = j;
            j++;
        }
        return n - ans;
    }
}