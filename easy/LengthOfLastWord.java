package easy;

class Solution {
    public int lengthOfLastWord(String s) {
        int res = 0;
        int tail = s.length() - 1;
        while(tail >= 0 && s.charAt(tail) == ' ') tail--;
        while(tail >= 0 && s.charAt(tail) != ' '){
            res++;
            tail--;
        }
        return res;
    }
}
