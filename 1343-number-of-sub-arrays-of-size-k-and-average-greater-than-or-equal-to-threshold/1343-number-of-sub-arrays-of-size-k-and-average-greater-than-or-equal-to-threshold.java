class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int ans = 0;
        int windowSum = 0;

        // first window
        for(int i = 0; i < k;i++){
            windowSum += arr[i];
        }
        if(windowSum / k >= threshold){
            ans++;
        }

        // sliding the window
        for(int i = k; i < n; i++){
            windowSum += arr[i] - arr[i-k];
            if(windowSum / k >= threshold){
                ans++;
            }
        }

        return ans;  
    }
}