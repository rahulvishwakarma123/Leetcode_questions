class Solution {
    // Expand around the center approach
    public String longestPalindrome(String s) {
        String longPal = s.substring(0,1);
        int n = s.length();

        for(int i = 0; i < n; i++){
            // for odd length palindrome
            int left = i -1;
            int right = i+1;
            while(left >= 0 && right < n){
                if(s.charAt(left) == s.charAt(right)){
                    if(longPal.length() < right - left + 1){
                        longPal = s.substring(left, right +1);
                    }
                    left--;
                    right++;
                }
                else{
                    break;
                }
            }


            // for even length palindrome
            left = i;
            right = i + 1;
            // same process for the evan length also.
            while(left >= 0 && right < n){
                if(s.charAt(left) == s.charAt(right)){
                    if(longPal.length() < right - left + 1){
                        longPal = s.substring(left, right +1);
                    }
                    left--;
                    right++;
                }
                else{
                    break;
                }
            }
        }

        return longPal;
    }
}