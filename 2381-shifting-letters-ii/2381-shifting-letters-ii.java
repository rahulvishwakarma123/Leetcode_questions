class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();

        int[] diff = new int[n];

        for(int[] row : shifts){
            int first = row[0];
            int second = row[1];
            int shift = row[2] == 1 ? 1 : -1;

            diff[first] += shift;
            if(second + 1 < n){
                diff[second+1] += -shift;
            }
        }

        // making the diff into prefix;
        StringBuilder sb = new StringBuilder();
        int currShift = 0;

        for (int i = 0; i < n; i++) {
            currShift += diff[i];

            int oldCode = s.charAt(i) - 'a';
            int newCode = Math.floorMod(oldCode + currShift, 26);

            sb.append((char)(newCode + 'a'));
        }

        return sb.toString();
    }
}