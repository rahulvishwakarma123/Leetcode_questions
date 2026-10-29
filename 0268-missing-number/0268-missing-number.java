class Solution {
    public void swap(int[] nums, int i, int correct){
        int temp = nums[i];
        nums[i] = nums[correct];
        nums[correct] = temp;
    }
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        int i = 0;
        while(i < n){
            int correct = nums[i];
            if(nums[i] >= n){
                i = i+1;
            }
            else if(nums[i] != nums[correct]){
                swap(nums, i, correct);
            }
            else i++;
        }

        i = 0;
        while(i < n){
            if(nums[i] != i){
                return i;
            }
            i++;
        }
        return n;
    }
}