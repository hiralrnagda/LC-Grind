class Solution {
    public int myAtoi(String s) {
        int i = 0, sign = +1, res = 0;
        int n = s.length();
        int MAX = Integer.MAX_VALUE, MIN = Integer.MIN_VALUE;
        while (i < n && s.charAt(i) == ' ')
        {
            i++;
        }
        
        if(i < n && s.charAt(i) == '+')
        {
            sign = 1;
            i++;
        } 
        else if(i < n && s.charAt(i) == '-')
        {
            sign = -1;
            i++;
        }
        
        while(i < n && Character.isDigit(s.charAt(i)))
        {
            int digit = s.charAt(i) - '0';
            if(res > MAX / 10 || (res == MAX / 10 && digit > MAX % 10))
            {
                return sign == 1 ? MAX : MIN;
            }
            res = res * 10 + digit;
            i++;
        }
        
        return res * sign;
    }
}