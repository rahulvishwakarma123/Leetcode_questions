class Solution {
    public boolean isVowel(String s, int i){
        char c = s.charAt(i);
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        return false;
    }
    public int maxVowels(String s, int k) {
        int n = s.length();
        int ans = 0;
        int max = 0;

        // first window;
        for(int i = 0; i < k; i++){
            if(isVowel(s, i)){
                ans++;
            }
        }

        max = Math.max(ans, max);

        // slide the window;
        for(int i = k; i < n; i++){
            if(isVowel(s, i)){
                ans++;
            }
            if(isVowel(s, i-k)){
                ans--;
            }

            max = Math.max(max, ans);
        }

        return max;
    }
}