class Solution {
    // TC: O(log N)
    // public boolean isPowerOfTwo(int n) {
    // if(n == 0) return false;

    // while(n % 2 == 0) n/=2;

    // return n == 1;
    // }

    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        } else if (n == 1) {
            return true;
        } else if (n % 2 == 0 && isPowerOfTwo(n / 2)) {
            return true;
        } else
            return false;
    }
}