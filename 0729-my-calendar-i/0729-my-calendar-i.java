class MyCalendar {
    public List<int[]> cal;
    public MyCalendar() {
        cal = new ArrayList<>();
    }
    
    public boolean book(int st, int end) {
        List<int[]> list = new ArrayList<>();
        boolean overlap = false;
        for(int i = 0; i < cal.size(); i++){
            int[] curr = cal.get(i);
            int s = curr[0];
            int e = curr[1];
            // overlap -> return true
            // lies before any interval and not merged yet
                // merge it and overlap = true
            // else new date lies on next interval
                // then add curr to new list
            if(e > st && end > s){
                return false;
            }
            else if(!overlap && s >= end){
                list.add(new int[]{st, end});
                list.add(curr);
                overlap = true;
            }
            else {
                list.add(curr);
            }
        }
        if(!overlap){
            list.add(new int[]{st, end});
        }
        cal = list;
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */