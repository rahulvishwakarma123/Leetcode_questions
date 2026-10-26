class Solution {
    // approach
        // make tow arrays of starting points and ending points 
            // starting points store the starting point
            // ending points store the ending points
            // we sort them in ascending order
            // we traverse them with i, j pointer
            // we manage a active variable to track intersection
            // if starting is less
                // active++
                // i++
            // else
                // active--
                // j++;
            // maxIntersection = Math.max(active, maxIntersection)
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        List<Integer> startings = new ArrayList<>();
        List<Integer> endings = new ArrayList<>();
        for(int[] interval: intervals){
            startings.add(interval[0]);
            endings.add(interval[1]);
        }
        Collections.sort(startings);
        Collections.sort(endings);

        int i = 0;
        int j = 0;
        int active = 0;
        int maxIntersection = 1; // we have atleast one group.
        while(i < startings.size() && j < endings.size()){
            if(startings.get(i) <= endings.get(j)){
                active++;
                i++;
            }else{
                active--;
                j++;
            }
            maxIntersection = Math.max(maxIntersection, active);
        }
        return maxIntersection;
    }
}