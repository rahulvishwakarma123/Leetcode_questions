class Solution {
    public int gcd(int a, int b){
        while(b != 0){
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
    public int lcm(int a, int b){
        return (a * b) / gcd(a,b);
    }
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            long prod = 1;
            int l = 1;
            int g = 0;
            for(int j = i; j < n; j++){
                prod *= nums[j];
                l = lcm(l, nums[j]);
                g = gcd(g, nums[j]);
                if(prod == l*g){
                    ans = Math.max(ans, j-i + 1);
                }
                if(prod > l*g){
                    break;
                }
            }
        }
        return ans;
    }
}