class Solution {
    // Aggressive cows code
    public boolean validForce(int[] position, int m, int force){
        int prevBallPos = 0;
        int curr = 1;
        for(int i = 1; i <= position.length - 1; i++){
            if(Math.abs(position[i] - position[prevBallPos]) >= force){
                curr++;
                prevBallPos = i;
            }
            if(curr >= m){
                return true;
            }
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position); // imp
        int low = 1;
        int max = position[position.length - 1] - position[0];
        int ans = -1;
        while(low <= max){
            int mid = low + (max - low) / 2;
            if(validForce(position, m, mid)){
                ans = mid;
                low = mid + 1;
            }
            else max = mid - 1;
        }
        return ans;
    }
}