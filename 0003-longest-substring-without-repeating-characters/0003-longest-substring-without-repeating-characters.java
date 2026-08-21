class Solution {
    // standard dynamic sliding window approach
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0) return 0;
        else if(n == 1) return 1;
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int res = Integer.MIN_VALUE;
        for(int right = 0; right < n; right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}