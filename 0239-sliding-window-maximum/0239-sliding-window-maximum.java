class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n-k+1];
        int j = -1;

        // Analysing the first window
        for(int i = 0; i < k; i++){
            while(dq.size() > 0 && nums[dq.peekLast()] <= nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }

        for(int i = k; i < nums.length; i++){
            // add the element of the previous window;
            j++;
            res[j] = nums[dq.peekFirst()];
            // remove the element from dq of the last window
            while(dq.size() > 0 && dq.peekFirst() <= i-k){
                dq.removeFirst();
            }
            // remove the element from the dq which is less than curr element
            while(dq.size() > 0 && nums[dq.peekLast()] <= nums[i]){
                dq.removeLast();
            }
            //add the curr element to the deque
            dq.addLast(i);
        }

        // add the element to the res of last window
        j++;
        res[j] = nums[dq.peekFirst()];

        return res;

    }
}