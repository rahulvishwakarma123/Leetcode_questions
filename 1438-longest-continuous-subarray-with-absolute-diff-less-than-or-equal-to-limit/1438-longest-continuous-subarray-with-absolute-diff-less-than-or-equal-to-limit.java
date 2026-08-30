class Solution {
    
    public int longestSubarray(int[] nums, int limit) {
        int i = 0,j; 
        int n = nums.length;
        int res = 0;
        // treemap to maintain the minimum and maximum frequency
        // minimum on the ffirst position and maximum on the last position
        TreeMap<Integer, Integer> map = new TreeMap<>();

        //move the right pointer one by on in search of maximum window
        for(j = 0; j < n; j++){
            // expanding thee window by taking the elements one by one
            map.put(nums[j], map.getOrDefault(nums[j],0) + 1);
            while(map.lastEntry().getKey() - map.firstEntry().getKey() > limit){
                map.put(nums[i], map.get(nums[i]) - 1);
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}