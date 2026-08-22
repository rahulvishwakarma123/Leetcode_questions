class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, res = Integer.MIN_VALUE;
        int n = fruits.length;

        for(int right = 0; right < n; right++){
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while(map.size() > 2){
                // left fruit
                int lf = fruits[left];
                map.put(lf, map.get(lf) - 1);
                if(map.get(lf) == 0){
                    map.remove(lf);
                }
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}