class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int i = 0;
        while(i < n){
            // if it is minus, then it is duplicate 
            // simply increase the counter and ignore it
            if(nums[i] < 0) {
                i++;
                continue;
            }
            int abs = Math.abs(nums[i]);
            int correct = abs - 1;
            if(abs != i+1){
                // if it is duplicate make it minus
                if(abs == Math.abs(nums[correct])){
                    nums[i] = -nums[i];
                    i++;
                }
                // otherwise swap it
                else {
                    int temp = nums[i];
                    nums[i] = nums[correct];
                    nums[correct] = temp;
                }
            }
            // element is on the correct place increase the iterator.
            else {
                i++;
            }
        }

        for(i = 0; i < n; i++){
            int num = nums[i];
            // if number is negative then i+1 is missing. 
            if(num < 0){
                res.add(i+1);
            }
        }

        return res;
    }
}