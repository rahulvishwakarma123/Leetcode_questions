class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        // prefix with size + 1 of array
        int[] prefix = new int[n+1];

        // hashmap for storing the freq of prefix sum;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int res = 0;


        // prefix[0] = 0;
        // then increase the freq of 0 prefix sum
        hm.put(0, 1);


        for(int i = 0; i < n; i++){
            //calculate the prefix for current index
            prefix[i+1] = prefix[i] + nums[i];
            int currPrefix = prefix[i+1];

            // need for subarray = currentPrefix - k
            // search in hashmap
            // if found - add the frequecy in result
            if(hm.containsKey(currPrefix - k)){
                res += hm.get(currPrefix - k);
            }

            // put the current prefix sum into the hashmap with frequency + 1;
            hm.put(currPrefix, hm.getOrDefault(currPrefix, 0) + 1);
        }

        return res;
    }
}