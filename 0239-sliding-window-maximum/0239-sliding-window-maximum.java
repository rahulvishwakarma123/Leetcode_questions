class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>(); // we store indexes instead of elements beacause we have to check that our element is in the window or not

        for(int i = 0; i < n; i++){
            while(!dq.isEmpty() && dq.peekFirst() <= i - k) // remove the elements which are outside the window
                dq.pollFirst();

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) // remove the elements which are less than current element because they are useless 
            // while doing that we are maintaining a sorted order (desc) in our deque.
                dq.pollLast();

            dq.offerLast(i);

            // window is >= k
            if(i >= k-1)
                res.add(nums[dq.peekFirst()]);
        }
        return res.stream().mapToInt(Integer :: intValue).toArray();
    }
}