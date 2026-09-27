class Solution {

    // kadan alternative approach.
    public long maxAlternatingSum(int[] nums) {
        long plus = 0;
        long minus = 0;
        for(int num : nums){
            // on the plus state we assume that we come from a minus state
            // either we skip the current element totally or add into the previous minus state.
            long newPlus = Math.max(plus, minus + num);

            // on the minus state we assume that we come from a plus state
            long newMinus = Math.max(minus, plus - num);

            plus = newPlus;
            minus = newMinus;
        }

        return plus;// because we always want that our subsequence ends at plus state.
    }
}