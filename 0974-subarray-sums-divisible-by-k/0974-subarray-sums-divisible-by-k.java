class Solution {
    // prefix sum + frequency count approach

    // important -> (((prefixSum % k)+k)%k) to round up the -ve values into corresponding positives.
    // (((prefixSum % k)+k)%k) -> round up the negative number to k then add k to make it positive then take the modulo to round up in positive.
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int prefixSum = 0, res = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);

        for(int i = 0; i< n; i++){
            prefixSum += nums[i];
            int remainder = (((prefixSum % k)+k)%k);
            if(hm.containsKey(remainder)){
                res += hm.get(remainder);
            }

            hm.put(remainder, hm.getOrDefault(remainder, 0) + 1);
            
        }
        return res;
    }
}