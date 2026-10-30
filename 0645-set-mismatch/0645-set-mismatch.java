class Solution {
    public void swap (int[] nums, int i, int correct){
        int temp = nums[i];
        nums[i] = nums[correct];
        nums[correct] = temp;
    }
    public int[] findErrorNums(int[] nums) {
        int i = 0;
        int n = nums.length;

        // this is cyclic sort loop TC: O(n)
        while(i < n){
            int correct = nums[i] - 1;
            if(nums[i] > n) i++;
            else if(nums[i] != nums[correct]){
                swap(nums, i, correct);
            }
            else i++;
        }

        int[] res = new int[2];
        i = 0;

        // for find missing and duplicate loop TC: O(n)
        for(int num = 1; num <= n; num++){
            if(nums[i] != num){
                res[0] = nums[i];
                res[1] = num;
                return res;
            }
            i++;
        }

        return res;
    }
}