class Solution {
    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[left] <= arr[mid]) {// on line 1 (sorted part)
                if(arr[left] <= target && arr[mid] >= target){
                    right = mid -1;
                }else left = mid + 1;
            }else{ // case for line 2;
                if(arr[mid] <= target && arr[right] >= target){
                    left = mid + 1;
                }
                else right = mid - 1;
            }
        }

        // target not found
        return -1;
    }
}