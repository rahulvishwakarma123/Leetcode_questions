class Solution {
    public int[] copies;
    public int[][] dp;
    public int minPrice;

    public int buyItems(int n, int budget, int[][] items){
        if(n <= 0){
            return budget / minPrice;
        }

        if(dp[n][budget] != -1){
            return dp[n][budget];
        }

        int take = 0;
        int price = items[n-1][1];
        if(price <= budget){
            take = 1 + copies[n-1] + buyItems(n-1, budget - price, items);
        }

        int skip = buyItems(n-1, budget, items);

        dp[n][budget] = Math.max(skip, take);

        return dp[n][budget];
    }
    
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        //                n
        // [[6,2],[2,6],[3,4]]

        copies = new int[n];
        minPrice = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            minPrice = Math.min(minPrice, items[i][1]);

            int freeCopy = 0;
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(items[j][0] % items[i][0] == 0){
                    freeCopy++;
                }
            }
            copies[i] = freeCopy;
        }

        dp = new int[n+1][budget+1];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        int res  = buyItems(n, budget, items);

        return res;

    }
}