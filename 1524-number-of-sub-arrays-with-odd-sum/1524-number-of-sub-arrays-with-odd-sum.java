class Solution {
    int mod = (int)1e9 + 7;
    public int numOfSubarrays(int[] arr) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = arr.length;
        map.put("even", 0);
        map.put("odd", 0);
        long prefix = 0;
        int ans = 0;
        for(int i = 0; i < n; i++){
            prefix += arr[i];
            if(prefix % 2 == 0){
                ans = (ans + map.get("odd")) % mod;
                map.put("even", map.get("even") + 1);
            }
            else{
                ans = (ans + map.get("even") + 1) % mod;
                map.put("odd", map.get("odd") + 1);
            }
        }
        return ans;
    }
}