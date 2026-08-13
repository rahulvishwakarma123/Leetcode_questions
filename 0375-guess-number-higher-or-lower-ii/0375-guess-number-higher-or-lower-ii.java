class Solution {
    public HashMap<String, Integer> dp;
    public int fx(int left, int right){
        String key = Integer.toString(left) + "_" + Integer.toString(right);

        if(dp.containsKey(key)) return dp.get(key);

        if(left + 1 == right) return Math.min(left, right);
        if(right <= left) return 0;

        int ans = Integer.MAX_VALUE;
        for(int k = left; k <= right; k++){
            int left_interval = fx(left, k-1);
            int right_interval = fx(k + 1, right);

            // dono choises me hame worst case leni hai kyuki hame maximum chahiye jitne me ham game jeet paye
            int cost = Math.max(left_interval + k, right_interval + k);

            // fir saare maximums me se sabse minimum chahiye.
            ans = Math.min(ans, cost); 
        }
        dp.put(key, ans);
        return ans;
    }
    public int getMoneyAmount(int n) {
        dp = new HashMap<>();
        return fx(1, n);
    }
}