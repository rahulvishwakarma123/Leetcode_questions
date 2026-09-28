class Solution {

    // kadane with one deletion variation.

    public int maximumSum(int[] arr) {
        if(arr.length == 1){
            return arr[0];
        }
        int noDel = arr[0]; // ye state ham use kar rahe hai kyuki agar ham ise nahi lenge to past me ek deletion karne ke baad agar current me ham kuch delete karna chahe to wo data nahi mil payega jisme past me koi element delete na hua ho kyuki hamare pass bas one deletion ka permission hai.

        int oneDel  = 0;
        int res = Integer.MIN_VALUE;
        for(int i = 1; i < arr.length; i++){
            int x = arr[i];

            // this is normal state in which we didn't delete any element.
            int newNoDel = Math.max(x, noDel + x);

            // in this state we have the ability to delete because we have all the best subarray with no deletion
            
            int newOneDel = Math.max(oneDel + x, noDel);
            // oneDel + arr[i] -> pahale ek deletion ho chuka hai tab current element jod denge oneDeletion variable state me.
            // noDel -> agar hm current wala element delete karna chah rahe hai to peechale tak ka best sum.

            noDel = newNoDel;
            oneDel = newOneDel;

            // take the best between noDel and oneDel.
            res = Math.max(res, Math.max(noDel, oneDel));
        }
        return res;
    }
}