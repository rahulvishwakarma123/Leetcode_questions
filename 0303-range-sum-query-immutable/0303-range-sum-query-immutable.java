class NumArray {
    public int[] prefix;
    public NumArray(int[] nums) {

        //we have to calculate prefix first 
        prefix = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                prefix[i] = nums[i];
            }
            else{
                prefix[i] = prefix[i-1] + nums[i];
            }
        }
    }
    
    public int sumRange(int left, int right) {
        // if you put for loop here then this function take O(n) every time it runs
        // that's why we calculate prefix sum on aur main array.NumArray
        if(left == 0){
            return prefix[right];
        }
        return prefix[right] - prefix[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */