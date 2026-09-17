class Solution {

    // row compression method of 2D matrix.
    public int numSubmat(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int res = 0;

        //fixing the top
        for(int top = 0; top < n; top++){

            int[] col = new int[m];
            Arrays.fill(col, 1);

            //fixing the bottom
            for(int bottom = top; bottom < n; bottom++){
                
                // populating the col array.
                for(int j = 0; j < m; j++){
                    col[j] &= mat[bottom][j];
                }

                int len = 0;
                // count the ractangles which can be formed using consecuting ones
                for(int j = 0; j < m; j++){
                    if(col[j] == 1){
                        len++;
                        res += len;
                    }else{
                        len = 0;
                    }
                }        
            }
        }

        return res;

        //TC = O(n^2*m)
    }
}