class Solution {
    // in this problem concept of binarySearch on ans + sliding window + rolling hash is applied for effecient solution.
    
    public long MOD = (long)1e9 + 7;
    public int base;

    public boolean check(int[] nums, int size){
        // [1,2,3,4,5]
        //    l
        //  h
        //    m
        // mid = 1
        // [1,1,2,2,1]
        //          l
        //            r
        // 11 - 1
        // 12 - 1
        // 22 - 1
        // 21 - 1
             // hash, freq
        HashMap<Long, Integer> map = new HashMap<>();
        int n = nums.length;
        int l = 0;
        int r = 0;
        long hash = 0;

        long power = 1;

        for (int i = 0; i < size - 1; i++) {
            power = (power * base) % MOD;
        }


        while(r < n){
            hash = ((hash * base) + nums[r]) % MOD;
            if(r - l + 1 < size){
                r++;
            }
            else{
                map.put(hash, map.getOrDefault(hash, 0) + 1);
                hash = ((hash - (nums[l] * power)) % MOD + MOD) % MOD;
                l++;
                r++;
            }
        }

        for(Map.Entry<Long, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return true;
            }
        }
        return false;
    }
    
    public int smallestUniqueSubarray(int[] nums) {
        base = Arrays.stream(nums).max().getAsInt() + 1;
        int l = 1;
        int h = nums.length;
        int ans = nums.length;
        while(l <= h){
            int mid = l + (h - l) / 2;
            if(check(nums, mid)){
                ans = mid;
                h = mid - 1;
            }
            else l = mid + 1;
        }
        return ans;
    }
}