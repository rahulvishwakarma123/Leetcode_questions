class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        // here we do not take the Integer.MAX_VALUE
        // because if target is in negative then closestSum - target overflows and become negative.
        int closestSum = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < n-2; i++){
            int st = i + 1, end = n-1;
            while(st < end){
                int sum = nums[i] + nums[st] + nums[end];
                if(Math.abs(sum - target) < Math.abs(target - closestSum)){
                    closestSum = sum;
                }

                if(sum < target){
                    st++;
                }else end--;
            }
        }
        return closestSum ;

    }
}