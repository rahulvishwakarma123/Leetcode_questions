class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;

        // approach:
        // 1: if elements are less than 1 return 0;
        if(n <= 1) return 0;
        
        // 2: make prefix array and hashmap to store sum and index of it to calculate the length of the subarray
        int[] prefix = new int[n];
        HashMap<Integer, Integer> hm = new HashMap<>();
        int res = 0;

        // 3: put the index -1 for sum 0 first
        hm.put(0, -1);

        // 4: on index 0 in prefix sum add +1 for 1 and -1 for 0 
        prefix[0] = nums[0] == 1 ? 1 : -1;
        hm.put(prefix[0], 0);
        
        // 5: iterate through every element from index 1 and calculate prefix sum according to the element
        for(int i = 1; i < n; i++){
            prefix[i] = nums[i] == 1 ? prefix[i-1]+1 : prefix[i-1]-1;

        // 6: find in hashmap if exist 
                // if yes calculate the length of subarray and compare
                // if no put the prefix sum in hashmap with index
            if(hm.containsKey(prefix[i])){
                res = Math.max(res, i - hm.get(prefix[i]));
            }else{
                hm.put(prefix[i], i);
            }

        }
        // return res 
        return res;
    }
}