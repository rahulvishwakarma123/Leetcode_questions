class MyCalendarThree {
    TreeMap<Integer, Integer> Timeline;
    public MyCalendarThree() {
        Timeline = new TreeMap<Integer, Integer>();
    }
    
    public int book(int st, int end) {
        Timeline.put(st, Timeline.getOrDefault(st, 0) + 1);
        Timeline.put(end, Timeline.getOrDefault(end, 0) - 1);

        int active = 0;
        int max = 0;

        for(int delta : Timeline.values()){ // learn this.
            active += delta;
            max = Math.max(max, active);
        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */