class Solution {

    // binary search on 2D matrix
    // approach: first find the row with binary search
                // apply binary search to find the row;
    public int findRow(int[][] matrix, int target){
        int n = matrix.length;
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = (left + right ) / 2;
            if(matrix[mid][0] <= target && matrix[mid][0] >= target){
                return mid;
            }
            else if(matrix[mid][0] < target) {
                left = mid + 1;
            }
            else right = mid - 1;
        }
        return right;
    }
    public boolean binarySearch(int[] arr, int target){
        int n = arr.length;
        int left = 0;
        int right = n-1;
        while(left <= right){
            int mid  = (left + right ) / 2;
            if(arr[mid] == target) return true;
            else if(arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIdx = findRow(matrix, target);
        if(rowIdx != -1) return binarySearch(matrix[rowIdx], target);
        else return false;
    }
}