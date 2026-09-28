class Solution {
    public int mod = 1000000000 + 7;
    public long kadane(int arr[]) {
        long curr = 0;
        long res = 0;
        for(int i = 0; i < arr.length; i++){
            curr = Math.max(arr[i], curr + arr[i]);
            res = Math.max(res, curr);
        }
        return res;
    }

    public long bestForTwoCopies(int[] arr){
        long curr= 0;
        long res = 0;
        for(int i = 0; i < 2 * arr.length; i++){
            curr = Math.max(arr[i % arr.length], curr + arr[i % arr.length]);
            res = Math.max(res, curr);
        }

        return res;
    }

    public int kConcatenationMaxSum(int[] arr, int k) {
        // if k == 1 then it is a simple kadane
        if(k == 1){
            return (int)(kadane(arr) % mod);
        }

        // find total sum, 
        long totalSum = 0;
        for(int x: arr){
            totalSum += x;
        }
        long res = 0;
        // if it is < 0 then no need take k arrays because it make our max sum lesser
        // only take 2 arrays take the last best part of 1st array and first best part of second array then return it.
        if(totalSum <= 0){
            res = bestForTwoCopies(arr);
        }else{

            // if total sum > 0 it is profitable to add the whole array in our res;
            // so add sum of remaining arrays - (k-2) arrays.
            res = bestForTwoCopies(arr) + ((k-2) * totalSum);
        }

        return (int)(res % mod);
    }
}