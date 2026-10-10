class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        List<int[]> res = new ArrayList<>();

        for(int[] curr: intervals){
            // if res is not empty and result's last interval's last element is greater than current's last element
            // then merge
            if(!res.isEmpty() && res.get(res.size() - 1)[1] >= curr[0]){
                int[] last = res.get(res.size() - 1);
                last[1] = Math.max(last[1], curr[1]);  
            }
            // ohterwise simply add the interval in the res;
            else{
                res.add(curr);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}