class Solution {
    public long minimumCost(int c1, int c2, int cBoth, int n1, int n2) {
        
        // there are total 4 possiblities
        long res = Long.MAX_VALUE;
        // c1 with (c2 || cboth)
        res = (long)c1 * n1 + Math.min((long)c2*n2, (long)cBoth * n2);

        // c2 with (c1 || cboth)
        res = Math.min(res, (long)c2 * n2 + Math.min((long)c1*n1, (long)cBoth * n1));
        
        if(n1 < n2){
            // cBoth for minimum 
            
            long totalCost = (long)cBoth * n1;
            long remainingNeedOfn2 = n2 - n1;
            totalCost += (long)c2 * remainingNeedOfn2;
            res = Math.min(res, totalCost);

            // cBoth for maximum
            res = Math.min((long)cBoth * n2, res);
        }
        else{
            // cBoth for minimum 
            long totalCost = (long)cBoth * n2;
            long remainingNeedOfn1 = n1 - n2;
            totalCost += (long)c1 * remainingNeedOfn1;
            res = Math.min(res, totalCost);

            // cBoth for maximum
            res = Math.min((long)cBoth * n1, res);
        }  

        return res;
    }
}