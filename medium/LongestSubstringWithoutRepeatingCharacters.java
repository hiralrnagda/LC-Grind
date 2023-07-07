import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        //instead of hashmap we can also use an array of 128 size
        Map<Character, Integer> map = new HashMap();
        int n = s.length();
        //left pointer to contract the window - contract when we encounter duplicate character
        //rightpointer to extend the window - expand when we have unique characters
        int left = 0, right = 0; 
        int len = 0;
        while(right < n)
        {
            if(map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }

            map.put(s.charAt(right), right);
            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }
}