class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;

        int i = 0;
        while(i < n){
            if(nums[i] < 0){
                i++;
                continue;
            }
            int absolute = Math.abs(nums[i]);
            int correct = absolute - 1;
            if(absolute != i+1){ // not on its correct position 
                if(absolute == Math.abs(nums[correct])){ // duplicate
                    res.add(nums[i]);
                    nums[i] = -nums[i];
                    i++;
                }
                else { // swap
                    int temp = nums[i];
                    nums[i] = nums[correct];
                    nums[correct] = temp;
                }
            }
            else i++;
        }

        return res;
    }
}