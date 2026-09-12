class Solution {
    // prefix sum + hashMap<modulo, index of mod> approach
    // SC: O(n)
    // TC: O(n)
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int sum = 0;
        int res = n;
        HashMap<Integer, Integer> hm = new HashMap<>();

        // formula -> (a+b) % p = (a%p + b%p) % p
        for(int elem: nums){
            sum = (sum + elem)%p;
        }

        int target = sum % p;

        if(target== 0) return 0;

        int curr = 0;
        hm.put(0, -1);

        for(int i = 0; i < n; i++){
            curr = (curr + nums[i]) % p;

            int find = (curr - target + p) % p;

            if(hm.containsKey(find)){
                res = Math.min(res, i - hm.get(find));
            }

            hm.put(curr, i);
        }

        return res == n ? -1 : res;
    }
}