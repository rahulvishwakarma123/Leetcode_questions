class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] pref = new int[n+1][m+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                pref[i][j] = mat[i-1][j-1]
                            + pref[i-1][j]
                            + pref[i][j-1]
                            - pref[i-1][j-1];
            }
        }

        int[][] res = new int[n][m];

        for(int i = 0; i< n; i++){
            for(int j = 0; j < m; j++){

                // this the calculation where I made the mistake
                int r1 = Math.max(0, i-k);
                int c1 = Math.max(0, j-k);

                // specially in r2 and c2
                int r2 = Math.min(n -1, i+k);
                int c2 = Math.min(m-1, j+k);
                c1++; c2++; r1++; r2++;


                res[i][j] = pref[r2][c2]
                            - pref[r1-1][c2]
                            - pref[r2][c1-1]
                            + pref[r1-1][c1-1]; 

            }
        }
        return res;
    }
}