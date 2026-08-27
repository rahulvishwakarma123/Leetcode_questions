class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length(), i = 0, res = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int k = 3; // because of 3 characters to check in the subarray
        for(int j = 0; j < n; j++){
            char curr = s.charAt(j);
            hm.put(curr, hm.getOrDefault(curr, 0) + 1);

            while(hm.size() >= k){
                char leftChar = s.charAt(i);
                // add all the valid substrings which is starting from i;
                // i to j is valid (found)
                // but all the strings after this valid substring is also valid thats why n - j;
                res += n - j;
                hm.put(leftChar, hm.get(leftChar) - 1);
                if(hm.get(leftChar) == 0) hm.remove(leftChar);
                i++;
            }
        }

        return res;
    }
}