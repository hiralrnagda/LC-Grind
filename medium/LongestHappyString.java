class Solution {
    /*
     * The idea behid this problem
     * 1. Here we start by taking the size as the sum of a, b, c.
     * 2. Then we use 3 variables A, B, C to count the occurance of a, b, c.
     * 3. Now we iterate until the size, and
     * -> Checks the largest number among a, b, c and whether the count < 2 or
     * whther the count of other letters is 2 and there is still letters that can be
     * added, then we append the letter, decrement from the total count of that
     * particular letter and increase the occurance of that letter and set others
     * back to zero.
     * 
     * 4. Finally return the string.
     */
    public String longestDiverseString(int a, int b, int c) {
        int A = 0, B = 0, C = 0;
        int n = a + b + c;
        StringBuilder s = new StringBuilder("");
        while (n != 0) {
            n--;
            if ((a >= b && a >= c && A != 2) || (B == 2 && a > 0) || (C == 2 && a > 0)) {
                s.append('a');
                A++;
                a--;
                B = 0;
                C = 0;
            } else if ((b >= a && b >= c && B != 2) || (A == 2 && b > 0) || (C == 2 && b > 0)) {
                s.append('b');
                B++;
                b--;
                A = 0;
                C = 0;
            } else if ((c >= b && c >= a && C != 2) || (B == 2 && c > 0) || (A == 2 && c > 0)) {
                s.append('c');
                C++;
                c--;
                A = 0;
                B = 0;
            }
        }
        return s.toString();
    }
}