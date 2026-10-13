class SummaryRanges {
    public List<Integer> list;
    public SummaryRanges() {
        list = new ArrayList<>();
    }
    
    public void addNum(int value) {
        list.add(value);
        Collections.sort(list);
    }
    
    public int[][] getIntervals() {
        int i = 0; 
        List<int[]> res = new ArrayList<>();
        // [1, 2, 2, 3, 3, 6, 7]
        //  
        //              j
        // curr = [1, 3], [6, 7];
        while(i < list.size()){
            int j = i;
            while(j + 1 < list.size() && (list.get(j) == list.get(j + 1) - 1 || list.get(j) == list.get(j + 1))){
                j++;
            }
            int[] curr = new int[]{list.get(i), list.get(j)};
            res.add(curr);
            i = j+1;
        }
        int[][] arr = new int[res.size()][2];
        for(i = 0; i < res.size(); i++){
            arr[i] = res.get(i);
        }
        return arr;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */