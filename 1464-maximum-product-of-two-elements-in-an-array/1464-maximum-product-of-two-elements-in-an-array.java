class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){

            // element is greater than first then transfer it's value to the second elem
            if(nums[i] > first){
                second = first;
                first = nums[i];
            }
            // if element is less than first then check it with second.
            else if(second < nums[i]){
                second = nums[i];
            }
        }

        return (first - 1) * (second - 1);
    }
}