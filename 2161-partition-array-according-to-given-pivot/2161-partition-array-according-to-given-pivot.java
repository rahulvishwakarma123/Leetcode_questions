class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0; int j = n-1;
        
        for(int left = 0, right= n-1; left < n; left++, right--){
            if(nums[left] < pivot){
                res[i] = nums[left];
                i++;
            }
            if(nums[right] > pivot){
                res[j] = nums[right];
                j--;
            }
        }

        for(int k = i; k <= j; k++){
            res[k] = pivot;
        }

        return res;

    }
}