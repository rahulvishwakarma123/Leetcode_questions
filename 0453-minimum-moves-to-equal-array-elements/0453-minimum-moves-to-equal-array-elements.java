class Solution {
    // increamenting n-1 elements by 1
    // instead we decrease 1 element by 1;
    // we know we have to decrease every element elem - min time
    public int minMoves(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
    
        for(int num: nums){
            min = Math.min(min, num);
        }

        int ans = 0;
        for(int num: nums){
            ans += num - min;
        }

        return ans;
    }
}