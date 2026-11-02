class Solution {
    // mathmatical way
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long grid_sum = 0;
        long grid_sq_sum = 0;
        int n = grid.length;
        long N = n * n;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                long num = grid[i][j];
                grid_sum += num;
                grid_sq_sum += (num * num);
            }
        }

        long sum = (N*(N+1))/2;
        long sq_sum = (N*(N+1)*((2*N)+1))/6;


        long sum_diff = grid_sum - sum;
        long sq_sum_diff = grid_sq_sum - sq_sum;

        long duplicate = ((sq_sum_diff/(sum_diff)) + sum_diff) / 2;
        long missing = ((sq_sum_diff/(sum_diff)) - sum_diff) / 2;

        return new int[]{(int)duplicate, (int)missing};
    }
}