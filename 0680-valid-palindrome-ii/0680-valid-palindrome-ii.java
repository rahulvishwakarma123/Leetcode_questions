class Solution {
    // always think of the brute force approach first
    public boolean validPalindrome(String s) {
        int st = 0;
        int end = s.length() -1;
        while(st < end){
            if(s.charAt(st) == s.charAt(end)){
                st++;
                end--;
            }
            else{
                return isPalindrome(s, st + 1, end) || isPalindrome(s, st, end-1);
            }
        }
        return true;
    }
    public boolean isPalindrome(String s, int st, int end){
        while(st < end){
            if(s.charAt(st) == s.charAt(end)){
                st++;
                end--;
            }else return false;
        }
        return true;
    }
}