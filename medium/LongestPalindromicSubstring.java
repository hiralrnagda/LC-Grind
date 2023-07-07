class Solution {
    int resStart;
    int resLen;
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n < 2) return s;
        
        for(int i = 0; i < n - 1; i++)
        {
            expandFromMiddle(s, i, i); //for odd lengh strings
            expandFromMiddle(s, i, i + 1); //for even length strings
        }
        return s.substring(resStart, resStart + resLen);
    }
    
    private void expandFromMiddle(String s, int begin, int end)
    {
        while(begin >= 0 && end < s.length() && (s.charAt(begin) == s.charAt(end)))
        {
            begin--;
            end++;
        }
        if(resLen < end - begin - 1)
        {
            resStart = begin + 1;
            resLen = end - begin - 1;
        }
    }
}