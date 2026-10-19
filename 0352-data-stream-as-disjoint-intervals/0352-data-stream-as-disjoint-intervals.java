class SummaryRanges {
    TreeSet<Integer> list;
    public SummaryRanges() {
        list = new TreeSet<>();
    }
    
    public void addNum(int value) {
        list.add(value);
    }

    // null   [1,2,3,6,7]
    //                   v
    //               i
    //                 j
    
    public int[][] getIntervals() {
        if(list.size() == 0) {
            return new int[][]{};
        }
        Integer left = null, right = null;
        List<int[]> res = new ArrayList<>();
        for(Integer val : list){
            if(left == null && right == null){
                left = val;
                right = val;
            }
            else if(val - 1 == right){
                right = val;
            }else{
                res.add(new int[]{left, right});
                left = val;
                right = val;
            }
        }
        res.add(new int[]{left, right});
        int[][] arr = new int[res.size()][2];

        for(int i = 0; i < res.size(); i++){
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