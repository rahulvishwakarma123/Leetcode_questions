class Solution {

    // 
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int left = 0, res = Integer.MIN_VALUE, maxFreq = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int right = 0; right < n; right++){
            char curr = s.charAt(right);
            hm.put(curr, hm.getOrDefault(curr, 0) + 1);
            maxFreq = Math.max(maxFreq, hm.get(curr));

            // shrink the window form the left to reduce the value
            while((right - left + 1) - maxFreq > k){
                char leftChar = s.charAt(left);
                hm.put(leftChar, hm.get(leftChar) -1);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
         return res;
    }
}