class Solution {
    // prefix sum + frequency count approach
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if(n <= 1) return false;

        // for mod, index of first mod
        HashMap<Integer, Integer> hm = new HashMap<>();
        int prefix = 0;
        hm.put(0, -1);
        for(int i = 0; i < n; i++){
            prefix += nums[i];

            int mod = ((prefix % k) + k) % k;
            
            if(hm.containsKey(mod) && i - hm.get(mod) > 1){
                return true;
            }

            if(!hm.containsKey(mod)){
                hm.put(mod, i);
            }
        }
        return false;
    }
}