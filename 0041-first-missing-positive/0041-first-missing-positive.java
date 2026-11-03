class Solution {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // [7, 8, 9, -2, 11,-3, 13, -6, -14, 12]
        //  i
        //            j
        // place all the negatives in the starting
        int i = 0, j = 0;
        while(i < n && nums[i] <= 0){
            i++;
        }

        if(i == n) return 1;

        j = i+1;
        while(j < n){
            if(nums[j] <= 0){
                swap(nums, i, j);
                i++;
            }
            j++;
        }

        //  0    1   2   3   4   5  6   7  8   9
        // [-2, -3, -6, -14, 11, 8, 13, 9, 7, 12]
        //                    i
        //                            j

        // find the minimum from i to n-1
        // min = 7
        int min = Integer.MAX_VALUE;
        for(int x = i; x < n; x++){
            min = Math.min(min, nums[x]);
        }
        // min = 7
        int offset = i - min; 
                    //  4 - 7  => -3

        //  0    1   2   3   4   5  6   7  8   9
        // [-2, -3, -6, -14, 7, 8, 9, 13, 11, 12]
        //                                        k 
        //                   i

        // apply cyclic sort
        int k = i;
        while(k < n){
            int correct = nums[k] + offset;
            if(nums[k] < n && correct < n && nums[k] != nums[correct]){
                swap(nums, k, correct);
            }
            else k++;
        }

        int element = 1;
        for(int x = i; x < n; x++){
            if(element != nums[x]){
                return element;
            }
            element++;
        }
        return element;
    }
}