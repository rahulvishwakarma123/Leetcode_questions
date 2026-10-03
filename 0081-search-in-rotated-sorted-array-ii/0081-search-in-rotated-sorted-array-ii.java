class Solution {
    public boolean search(int[] nums, int target) {
        int si = 0;
        int ei = nums.length - 1;
        return binarySearch(nums, target, si, ei);
    }
    
    public static boolean binarySearch(int[] arr, int target, int si, int ei){
        if(si > ei){
            return false;
        }
        
        int mid = si + (ei - si)/2;
        
        // found case
        if (arr[mid] == target) {
            return true;
        }
        
        // Handle duplicates by moving pointers
        if (arr[si] == arr[mid] && arr[mid] == arr[ei]) {
            return binarySearch(arr, target, si+1, ei-1);
        }

        // mid on line1 (left sorted portion)
        if (arr[si] <= arr[mid]) {
            // case: target in left sorted portion
            if (arr[si] <= target && target < arr[mid]) {
                return binarySearch(arr, target, si, mid-1);
            }
            // case: target in right portion
            else{
                return binarySearch(arr, target, mid+1, ei);
            }
        }
        // mid on line2 (right sorted portion)
        else{
            // case: target in right sorted portion
            if (arr[mid] < target && target <= arr[ei]) {
                return binarySearch(arr, target, mid+1, ei);
            }
            // case: target in left portion
            else{
                return binarySearch(arr, target, si, mid-1);
            }
        }
    }
}