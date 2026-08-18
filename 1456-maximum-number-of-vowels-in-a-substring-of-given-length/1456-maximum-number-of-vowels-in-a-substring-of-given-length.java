class Solution {
    public int maxVowels(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('a', 'a' - 'a');
        hm.put('e', 'e' - 'a');
        hm.put('i', 'i' - 'a');
        hm.put('o', 'o' - 'a');
        hm.put('u', 'u' - 'a');


        int n = s.length();
        int ans = 0;
        int max = 0;

        // first window;
        for(int i = 0; i < k; i++){
            if(hm.containsKey(s.charAt(i))){
                ans++;
            }
        }

        max = Math.max(ans, max);

        // slide the window;
        for(int i = k; i < n; i++){
            if(hm.containsKey(s.charAt(i))){
                ans++;
            }
            if(hm.containsKey(s.charAt(i-k))){
                ans--;
            }

            max = Math.max(max, ans);
        }

        return max;
    }
}