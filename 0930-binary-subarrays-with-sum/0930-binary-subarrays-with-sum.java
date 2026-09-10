class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int sum = 0;
        int res = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        hm.put(0, 1);
        for(int i = 0; i < n; i++){
            sum += nums[i];

            if(hm.containsKey(sum - goal)){
                res += hm.get(sum - goal);
            }

            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}