class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        // take middle so we can decide where to go?
        int r = 0;
        int c = m-1;
        while(r < n && c >= 0){
            int curr = matrix[r][c];

            if(curr == target) return true;
            // is small go down
            else if(curr < target) r++;
            // if greater go left
            else c--;
        }

        return false;
    }
}