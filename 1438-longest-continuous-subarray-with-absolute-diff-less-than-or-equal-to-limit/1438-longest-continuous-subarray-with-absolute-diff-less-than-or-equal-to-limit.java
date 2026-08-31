class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> min = new ArrayDeque<>();
        Deque<Integer> max = new ArrayDeque<>();
        int n = nums.length;
        int i = 0, j;
        for(j = 0; j < n; j++){

            // maintaining the order in min and max deque;
            while(!min.isEmpty() && nums[j] < min.peekLast()){
                min.pollLast();
            }
            while(!max.isEmpty() && nums[j] > max.peekLast()){
                max.pollLast();
            }

            min.addLast(nums[j]);
            max.addLast(nums[j]);

            // agar curr i pe jo element hai ya to wo already remove ho gaye honge ya nahi hue honge to iska matalab wo ya to greatest ya lowest element in the window hai to ham unhe remove kar denge kyuki condition voilate kar rahi hai.
            if(max.peek() - min.peek() > limit){
                if(min.peek() == nums[i]) min.poll();
                if(max.peek() == nums[i]) max.poll();
                i++;
            }
        }
        return j - i;
    }
}