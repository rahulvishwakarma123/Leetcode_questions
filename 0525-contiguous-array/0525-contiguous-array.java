class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;

        // approach:
        // 1: if elements are less than 1 return 0;
        if(n <= 1) return 0;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        int res = 0;
        int sum = 0;

        hm.put(0, -1);

        for(int i = 0; i < n; i++){
            sum += nums[i] == 1 ? 1 : -1;

            if(hm.containsKey(sum)){
                res = Math.max(res, i - hm.get(sum));
            }
            else{
                hm.put(sum, i);
            }
        }
        return res;
    }
}