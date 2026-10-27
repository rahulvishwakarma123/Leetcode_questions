class Solution {
     // 0 1 2 3 4 5 6 7
    // [1,2,4,5,6,8,9,10]
    //            m
    //              l              
    //            h
    public int upperBound(int[] arr, int target){
        int l = 0;
        int h = arr.length;
        while(l < h){
            int mid = l + (h - l)/2;
            if(arr[mid] <= target){
                l = mid + 1;
            }
            else { 
                h = mid;
            }
        }
        return l;
    }
    public int lowerBound(int[] arr, int target){
        int l = 0;
        int h = arr.length;
        while(l < h){
            int mid = l + (h - l)/2;
            if(arr[mid] < target){
                l = mid + 1;
            }
            else { 
                h = mid;
            }
        }
        return l;
    }
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        // binary search approach
            // make start[] and end[] array
            // sort them
            // find upper_bound in start and lower bound in end for each day
            // ans[i] = upper_bound - lower_bound
        
        int n = flowers.length;
        int m = people.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for(int i = 0; i < n; i++){
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int[] ans = new int[m];

        for(int i = 0; i < m; i++){
            int day = people[i];

            int bloomed = upperBound(start, day);
            int died = lowerBound(end, day);

            ans[i] = bloomed - died;

        }
        return ans;
    }
}