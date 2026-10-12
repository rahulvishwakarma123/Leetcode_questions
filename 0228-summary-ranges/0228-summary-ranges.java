class Solution {
    public List<String> summaryRanges(int[] nums) {
        // i
        //[0,1,2,4,5,7]
       //    j
        int n = nums.length;
        if(n == 0) return new ArrayList<String>();
        List<String> list = new ArrayList<>();
        if(n == 1) {
            list.add(Integer.toString(nums[0]));
            return list;
        }

        int i = 0;
        while(i < nums.length){
            int j = i;
            while(j+1 < n && nums[j] == nums[j+1] - 1){
                j++;
            }
            if(j == i){
                list.add(Integer.toString(nums[i]));
            }
            else{
                list.add(Integer.toString(nums[i]) + "->" + Integer.toString(nums[j]));
            }
            i = j + 1;
        }
        return list;
    }
}