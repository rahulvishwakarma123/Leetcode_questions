class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        // approach 
            // make a saparate array of starting and endiing and sort them
            // sort the people array by storing their order preserve because we have to return ans in that particular order
            // travers on the people array and apply a concept like sweep line
            // starting[i] <= people[k]
                // active++
            // ending[j] < people[k]
                // active--;

        int n = flowers.length; 
        int m = people.length; //[3,3,2]

        int[] startings = new int[n];
        int[] endings = new int[n];

        int a = 0;
        for(int[] flower: flowers){
            startings[a] = flower[0];
            endings[a] = flower[1];
            a++;
        }

        Integer[] order = new Integer[m]; //[0,1,2]
        for(int i = 0; i < m; i++){
            order[i] = i;
        }

        Arrays.sort(startings);
        Arrays.sort(endings);

        // sort the order array which store the index of people's arriving day.
        Arrays.sort(order, (x, y)->{
            return Integer.compare(people[x], people[y]);
        });

        int[] ans = new int[m];
        int i = 0;
        int j = 0;
        int active = 0;

        for(int k = 0; k < m; k++){
            int index = order[k];
            int day = people[index];

            while(i < n && startings[i] <= day){
                active++;
                i++;
            }
            while(j < n && endings[j] < day){
                active--;
                j++;
            }
            ans[index] = active;
        }

        return ans;
    }
}