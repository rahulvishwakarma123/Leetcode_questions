class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums, k) - solve(nums, k-1);
    }


    // this function find the subarrays which contains less than k elments.
    public int solve(int[] nums, int k){
        int n = nums.length, left = 0, res = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int right = 0; right < n; right++){
            hm.put(nums[right], hm.getOrDefault(nums[right], 0) + 1);
            while(hm.size() > k){
                hm.put(nums[left], hm.get(nums[left]) - 1);
                if(hm.get(nums[left]) == 0){
                    hm.remove(nums[left]);
                }
                left++;
            }
            res += right - left + 1;
        }

        return res;
    }
}