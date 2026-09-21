class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        // prefix xor array.
        int prefixOf1 = 0;

        for(int i = 0; i < n; i++){
            prefixOf1 ^= nums1[i];
        }
        boolean even = (n%2 == 0) ? true : false;

        int ans = 0;
        for(int i = 0; i < m; i++){
            ans ^= prefixOf1;
            if(!even) ans^= nums2[i];
        }
        return ans;
    }
}