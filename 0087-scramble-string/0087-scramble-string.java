class Solution {

    // Memoization:
    // key = "s1_s2"
    // value = whether s1 can be scrambled to form s2
    HashMap<String, Boolean> memo = new HashMap<>();

    public boolean solve(String s1, String s2) {

        // Different lengths can never be scramble strings
        if (s1.length() != s2.length()) {
            return false;
        }

        // If both strings are already equal,
        // no scrambling is required.
        if (s1.equals(s2)) {
            return true;
        }

        // Check memoized result
        String key = s1 + "_" + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int n = s1.length();

        // If length is 1, the strings are not equal
        // (because equal case was already handled above)
        if (n == 1) {
            return false;
        }

        /*
         * Optimization:
         * Both strings must contain the same characters
         * with the same frequencies.
         *
         * Example:
         * s1 = "great"
         * s2 = "abcde"
         *
         * No need to recurse because characters differ.
         */
        // int[] freq = new int[26];

        // for (int i = 0; i < n; i++) {
        //     freq[s1.charAt(i) - 'a']++;
        //     freq[s2.charAt(i) - 'a']--;
        // }

        // for (int count : freq) {
        //     if (count != 0) {
        //         memo.put(key, false);
        //         return false;
        //     }
        // }

        boolean result = false;

        /*
         * Try every possible partition.
         *
         * Example:
         * s1 = "great"
         *
         * k = 1  -> "g" | "reat"
         * k = 2  -> "gr" | "eat"
         * k = 3  -> "gre" | "at"
         * k = 4  -> "grea" | "t"
         */
        for (int k = 1; k < n; k++) {

            /*
             * Case 1: No Swap
             *
             * s1 = gr | eat
             * s2 = ea | tgr
             *
             * Compare:
             * left  with left
             * right with right
             */
            boolean notSwapped =
                    solve(s1.substring(0, k), s2.substring(0, k))
                    &&
                    solve(s1.substring(k), s2.substring(k));

            /*
             * Case 2: Swap
             *
             * s1 = gr | eat
             * s2 = eat | gr
             *
             * Compare:
             * left part of s1  with right part of s2
             * right part of s1 with left part of s2
             */
            boolean swapped =
                    solve(s1.substring(0, k), s2.substring(n - k))
                    &&
                    solve(s1.substring(k), s2.substring(0, n - k));

            // If either configuration works,
            // strings are scramble strings.
            if (notSwapped || swapped) {
                result = true;
                break;
            }
        }

        memo.put(key, result);
        return result;
    }

    public boolean isScramble(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        return solve(s1, s2);
    }
}