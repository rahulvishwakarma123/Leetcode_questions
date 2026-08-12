class Solution {

    public int maxArea(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        // dp[i][j] = largest square ending at (i, j)
        int[][] dp = new int[m][n];

        int maxSide = 0;

        // Maximal Square DP -> TC = O(n*m)
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (mat[i][j] == 1) {

                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1 + Math.min(
                                dp[i - 1][j],
                                Math.min(
                                        dp[i][j - 1],
                                        dp[i - 1][j - 1]
                                )
                        );
                    }

                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        // Binary search on side length TC -> O(log(min(m,n)))
        int low = 1;
        int high = maxSide;
        int ans = 0;

        while (low <= high) {

            int k = low + (high - low) / 2;

            if (can(k, dp)) {
                ans = k;
                low = k + 1;
            } else {
                high = k - 1;
            }
        }

        return ans * ans;
    }


    private boolean can(int k, int[][] dp) { // TC -> O(m*n)

        int m = dp.length;
        int n = dp[0].length;

        /*
         * rowHas[r] = there exists a valid k*k square
         * whose top-left corner is in row r.
         *
         * colHas[c] = there exists a valid k*k square
         * whose top-left corner is in column c.
         */
        boolean[] rowHas = new boolean[m];
        boolean[] colHas = new boolean[n];


        // Find every valid k*k square
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (dp[i][j] >= k) {

                    /*
                     * (i,j) is bottom-right corner.
                     *
                     * Convert it to top-left corner.
                     */
                    int r = i - k + 1;
                    int c = j - k + 1;

                    rowHas[r] = true;
                    colHas[c] = true;
                }
            }
        }


        // -----------------------------------------
        // Vertical separation
        // -----------------------------------------

        boolean[] prefixRow = new boolean[m];
        boolean[] suffixRow = new boolean[m];

        prefixRow[0] = rowHas[0];

        for (int r = 1; r < m; r++) {
            prefixRow[r] = prefixRow[r - 1] || rowHas[r];
        }

        suffixRow[m - 1] = rowHas[m - 1];

        for (int r = m - 2; r >= 0; r--) {
            suffixRow[r] = suffixRow[r + 1] || rowHas[r];
        }


        /*
         * First square can start somewhere in [0 ... r].
         *
         * Second square must start at >= r+k.
         */
        for (int r = 0; r + k < m; r++) {

            if (prefixRow[r] && suffixRow[r + k]) {
                return true;
            }
        }


        // -----------------------------------------
        // Horizontal separation
        // -----------------------------------------

        boolean[] prefixCol = new boolean[n];
        boolean[] suffixCol = new boolean[n];

        prefixCol[0] = colHas[0];

        for (int c = 1; c < n; c++) {
            prefixCol[c] = prefixCol[c - 1] || colHas[c];
        }

        suffixCol[n - 1] = colHas[n - 1];

        for (int c = n - 2; c >= 0; c--) {
            suffixCol[c] = suffixCol[c + 1] || colHas[c];
        }


        /*
         * First square can start somewhere in [0 ... c].
         *
         * Second square must start at >= c+k.
         */
        for (int c = 0; c + k < n; c++) {

            if (prefixCol[c] && suffixCol[c + k]) {
                return true;
            }
        }

        return false;
    }


    // overall time complexity = O((m*n) * log(min(m,n)))
}                               // m*n for dp
                                // log(min(m,n)) for binary search
