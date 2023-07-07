class Solution {
    /**
     * Note that we can only decrement a number and cannot increment it. Hence, if
     * we have two equal numbers, we will have to make one of these numbers smaller
     * to make them unique.
     */
    public int minDeletions(String s) {
        int del = 0;
        // create a freq map
        int freq[] = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // because we want to make the freq unique - we will use the set
        Set<Integer> uniqueFreq = new HashSet<Integer>();
        for (int count : freq) {
            while (count > 0 && uniqueFreq.contains(count)) {
                del++;
                count--;
            }
            uniqueFreq.add(count);
        }

        return del;
    }
}