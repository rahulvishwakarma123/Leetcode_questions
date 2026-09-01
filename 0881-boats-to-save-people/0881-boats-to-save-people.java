class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        int st = 0;
        int end = n-1;
        int res = 0;
        int weight = 0;
        Arrays.sort(people);
        while(st < end){
            if(people[st] + people[end] <= limit){
                res++;
                st++;
                end--;
            }
            else{
                res++;
                end--;
            }
        }
        if(st == end) res++;
        return res;
    }
}