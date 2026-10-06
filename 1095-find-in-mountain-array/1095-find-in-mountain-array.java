/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int peakIndex(MountainArray arr){
        int st = 0;
        int end = arr.length() - 1;
        while(st <= end){
            int mid = st + (end - st) / 2;
            int curr = arr.get(mid);
            int next = mid + 1 >= arr.length() ? Integer.MIN_VALUE : arr.get(mid + 1);
            int prev = mid - 1 < 0 ? Integer.MIN_VALUE : arr.get(mid - 1);

            if(curr > prev && curr > next){
                return mid;
            }
            else if(curr < next){
                st = mid + 1;
            }
            else end = mid - 1;
        }
        return -1;
    }
    public int findInLeft(MountainArray arr, int target, int st, int end){
        while(st <= end){
            int mid = st + (end - st) / 2;
            int curr = arr.get(mid);
            if(curr == target) return mid;
            else if(curr < target){
                st = mid + 1;
            }
            else end = mid - 1;
        }
        return -1;
    }
    public int findInRight(MountainArray arr, int target, int st, int end){
        while(st <= end){
            int mid = st + (end - st) / 2;
            int curr = arr.get(mid);
            if(curr == target) return mid;
            else if(curr < target){
                end = mid - 1;
            }
            else st = mid + 1;
        }
        return -1;
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        // first find the peak index;
        int peak = peakIndex(mountainArr);

        // if peak index is out target then return it 
        // because there is not any other peak index less than this.
        if(mountainArr.get(peak) == target) return peak;

        // now first search in the left of the array because we have to return the minimum index
        int left = findInLeft(mountainArr, target, 0, peak - 1);
        if (left == -1){
            // if target is not found in left then search in the right and return it.
            return findInRight(mountainArr, target, peak + 1, mountainArr.length() - 1);
        }
        return left;
    }
}