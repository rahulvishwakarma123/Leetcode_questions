class Solution {

    // 2d prefix row compression method. 
    // TC = O(n^3);
    public int numSubmatrixSumTarget(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;

        int ans = 0;

        // fix top
        for(int top = 0; top < n; top++){
            // make a compressed array for this top
            int[] compressed = new int[m];

            //fix a botttom
            for(int bottom = top; bottom < n; bottom++){
                for(int j = 0; j < m; j++){
                    compressed[j] += mat[bottom][j];
                }
                

                // call count subArray for a target - LC 560
                ans += countSubarrays(compressed, target);
            }
        }
        return ans;
    }

    public int countSubarrays(int[] arr, int k){
        int n = arr.length;
        int prefix= 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        int res = 0;

        for(int i = 0; i < n; i++){
            prefix += arr[i];
            if(hm.containsKey(prefix - k)){
                res += hm.get(prefix - k);
            }

            hm.put(prefix, hm.getOrDefault(prefix, 0) + 1);
        }

        return res;
    }
}