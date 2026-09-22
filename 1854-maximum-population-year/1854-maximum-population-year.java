class Solution {
    
    // sweepline method.
    public int maximumPopulation(int[][] logs) {
        List<int[]> events = new ArrayList<>();

        for(int[] x: logs){
            int b = x[0];
            int d = x[1];

            events.add(new int[]{b, +1});
            events.add(new int[]{d, -1});
        }

        Collections.sort(events, (a, b) ->{
            if(a[0] != b[0]){
                return Integer.compare(a[0], b[0]);
            }else return Integer.compare(a[1], b[1]);
        });

        int alive = 0;
        int maxAlive = Integer.MIN_VALUE;
        int ans = 0;

        for(int[] event: events){
            int type = event[1];
            int year = event[0];
            if(type == 1){
                alive++;
            }else{
                alive--;
            }

            if(alive > maxAlive){
                maxAlive = alive;
                ans = year;
            }

        }

        return ans;
    }
}