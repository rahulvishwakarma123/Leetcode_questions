class MyCalendarTwo {
    // Time complexity -> O(2n)
    // Space complexity -> O(2n)
    public List<int[]> bookings;
    public List<int[]> doubleBookings = new ArrayList<>();
    public MyCalendarTwo() {
        bookings = new ArrayList<>();
    }
    
    public boolean book(int st, int et) {
        // algo 
            // check the triple booking
                // if overlap return false;
            // check the double booking
                // if overlap exist add intersection area in double booking
                // add the booking in bookings array;
                // return true;

        // interval1 = (a,b), interval2 = (c,d);
        // a.................b
        //          c................d
        //          x........y    -> intersection area


        // for finding interval if(Math.max(a,c) < Math.min(b,d))
        // for intersection x -> Math.max(a,c), y -> Math.min(b,d);


        for(int i = 0; i < doubleBookings.size(); i++){
            int[] curr = doubleBookings.get(i);
            if(Math.max(curr[0], st) < Math.min(curr[1], et)){
                return false;
            }
        }


        for(int i = 0; i < bookings.size(); i++){
            int[] curr = bookings.get(i);

            // overlap -> add to double booking
            if(Math.max(curr[0], st) < Math.min(curr[1], et)){
                doubleBookings.add(new int[]{Math.max(curr[0], st), Math.min(curr[1], et)});
            }
        }
        // book the new interval in bookings
        bookings.add(new int[]{st, et});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */