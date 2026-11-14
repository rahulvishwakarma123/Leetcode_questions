class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] prefix = new int[n+1];
        // 1. build prefix array
        for(int i = 0; i < n; i++){
            prefix[i+1] = prefix[i] + nums.get(i);
        }

        // TreeMap gives strikly lower prefix than current prefix, so that we can find positive sum in O(n) complexity
        // key = prefix, value = freq of prefix
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int ans = Integer.MAX_VALUE;

        // interate over every right prefix index
        for(int k = l; k <= n; k++){
            int add = prefix[k-l];

            // add newly eligible prefix
            map.put(add, map.getOrDefault(add, 0) + 1);

            // remove old prefix that exceed the max length
            int removeIdx = k-r-1;

            if(removeIdx >= 0){
                int remove = prefix[removeIdx];
                int freq = map.get(remove);

                if(freq == 1){
                    map.remove(remove);
                }
                else{
                    map.put(remove, map.get(remove) - 1);
                }
            }

            // 4. find the largest prefix sum strictly smaller than current prefix sum
            Integer candidate = map.lowerKey(prefix[k]);
            if(candidate != null){
                int currentSum = prefix[k] - candidate;

                ans = Math.min(ans, currentSum);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}