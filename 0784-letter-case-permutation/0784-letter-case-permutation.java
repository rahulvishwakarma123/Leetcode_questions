class Solution {

    public void solve(String si, String so, List<String> res){
        int n = si.length();
        if(n <= 0){
            res.add(new String(so));
            return;
        }

        String c = String.valueOf(si.charAt(0)).toLowerCase();
        int code = c.codePointAt(0);

        solve(si.substring(1, n), so + c, res);

        if((code <= 90 && code >= 65) || (code >= 97 && code <= 122)){
            solve(si.substring(1, n), so + c.toUpperCase(), res);
        }
    }
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();

        solve(s, "", res);

        return res;
    }
}