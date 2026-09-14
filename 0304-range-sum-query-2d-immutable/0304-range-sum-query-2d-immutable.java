class NumMatrix {


    // 2D prefix approach.
    public int[][] pref;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        pref = new int[n+1][m+1];

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                pref[i][j] = matrix[i-1][j-1] // decrease -1 because we have extra col and row in our prefix matrix.
                            + pref[i-1][j] // (top)
                            + pref[i][j-1] // left
                            - pref[i-1][j-1]; // overlap
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = pref[row2 + 1][col2 + 1];
        int top = pref[row1][col2 + 1];
        int left = pref[row2 + 1][col1];
        int overlap = pref[row1][col1];

        return total - top - left + overlap;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */