class Solution {
    public int maximumGap(String skill, String station) {
        int n = skill.length();
        if(n <= 1){
            return 0;
        }

        int m = station.length();

        int[] left = new int[n];
        int[] right = new int[n];

        int idx  =  0;
        for(int i = 0; i < m; i++){
            if(skill.charAt(idx) == station.charAt(i)){
                left[idx] = i;
                idx++;
            }
            if(idx >= n) break;
        }

        idx = n-1;
        for(int i = m-1; i>=0; i--){
            if(skill.charAt(idx) == station.charAt(i)){
                right[idx] = i;
                idx--;
            }
            if(idx < 0) break;
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++){
            ans = Math.max(ans, right[i] - left[i-1]);
        }

        return ans;
    }
}