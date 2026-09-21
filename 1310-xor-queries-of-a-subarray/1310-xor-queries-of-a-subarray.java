class Solution {
    // prefix xor approach
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefixXor = new int[arr.length];

        prefixXor[0] = arr[0]; // because arr[0] ^ 0;
        
        // calculate the prefix xor
        for(int i = 1; i < arr.length; i++){
            prefixXor[i] = arr[i]^prefixXor[i-1];
        }
        int i = 0;
        int[] res = new int[queries.length];

        // traverse on queries and calculate the ans with the help of prefixXor array.
        for(int[] query : queries){
            int l = query[0];
            int r = query[1];

            if(l <= 0){
                res[i] = prefixXor[r] ^ 0;
            }
            else{
                res[i] = prefixXor[r] ^ prefixXor[l-1];
            }
            i++;
        }

        return res;
    }
}