class MyCalendar {
    public List<int[]> cal;
    public MyCalendar() {
        cal = new ArrayList<>();
    }
    
    public boolean book(int st, int end) {
        int idx = findInsertingIdx(st, end);
        if(idx == -1) return false;
        if(idx == cal.size()) {
            cal.add(new int[]{st, end});
            return true;
        }
        else{
            insertInterval(idx, st, end);
            return true;
        }
        
    }

    // find inserting iindex or return -1 if overlap;
    public int findInsertingIdx(int st, int end){
        for(int i = 0; i < cal.size(); i++){
            int s = cal.get(i)[0];
            int e = cal.get(i)[1];

            // overlap
            if(e > st && end > s){
                return -1;
            }
            else if(s >= end){
                return i;
            }
        }
        return cal.size();
    }

    // insert interval to the calander;
    public void insertInterval(int idx, int st, int end){
        int[] intervalToSet = new int[]{st, end};
        int i = idx;
        while(i < cal.size()){
            int[] curr = cal.get(i);    
            cal.set(i, intervalToSet);
            intervalToSet = curr;
            i++;
        }
        cal.add(intervalToSet);
    }

}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */