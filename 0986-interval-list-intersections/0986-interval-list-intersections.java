class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();

        int i = 0;
        int j = 0;
        int n = firstList.length;
        int m = secondList.length;
        while(i < n && j < m){
            int s1 = firstList[i][0];
            int e1 = firstList[i][1];
            int s2 = secondList[j][0];
            int e2 = secondList[j][1];

            // [[0,2],[5,10],[13,23],[24,25]]
            //          i
            // [[1,5],[8,12],[15,24],[25,26]]
            //    j
            // store the intersection in the res
            if(e1 >= s2 && e2 >= s1){
                res.add(new int[]{Math.max(s1, s2), Math.min(e1, e2)});
            }


            // increase the interval iterator which ends first
            if(e1 < e2){
                i++;
            }else j++;
        }

        int resA[][] = new int[res.size()][2];
        for(int k = 0; k < res.size(); k++){
            resA[k] = res.get(k);
        }
        return resA;
    }
}