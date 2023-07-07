class Solution {
    public int minimumDeletions(String s) {
        // Consider b as a friendly character and a as enemy character
        // so ideal case would be to encounter only b's
        // if we encounter a then we are suppose to make any deletions - check if b were
        // present before the current a and update the minCount variable
        int minCount = 0, bCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                minCount = Math.min(minCount + 1, bCount);
            } else {
                bCount++;
            }
        }
        return minCount;
    }
}