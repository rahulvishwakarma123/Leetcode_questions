class Solution {
    public int findMin(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while(low < high){
            // if low == high then we must stand on the lowest element
            int mid = low + (high - low) / 2;
            if(arr[high] < arr[mid]){
                // here we can discard the mid because mid is greater than high
                // so mid never become an ans
                low = mid + 1;
            }
            // this is the most important part of the problem
            // that we have to do high = mid
            else high = mid; 
        }
        return arr[low];
    }
}