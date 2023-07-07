class Solution {
    // Approach 1: using stack extra O(n) space
    // public String reverseWords(String s) {
    // char charArray[] = s.toCharArray();
    // Stack<String> stack = new Stack();
    // String word = "";

    // for(int i = 0; i < s.length(); i++)
    // {
    // while(i < s.length() && charArray[i] == ' '){
    // i++;
    // }

    // while(i < s.length() && charArray[i] != ' '){
    // word += charArray[i];
    // i++;
    // }

    // stack.push(word);
    // word = "";
    // }

    // String ans = "";
    // while(!stack.empty())
    // {
    // String top = stack.pop();
    // ans = ans + ' ' + top;
    // }

    // return ans.trim();
    // }

    // approach2: O(1) space
    public String reverseWords(String s) {
        int i = s.length() - 1;
        String ans = "";
        while (i >= 0) {
            // handles trailing spaces
            while (i >= 0 && s.charAt(i) == ' ')
                i--;

            int j = i;

            // handles leading spaces
            if (i < 0)
                break; // this would ensure that

            while (i >= 0 && s.charAt(i) != ' ')
                i--;

            if (ans.isEmpty()) {
                ans = ans.concat(s.substring(i + 1, j + 1));
            } else // handle the space between 2 words
            {
                ans = ans.concat(" " + s.substring(i + 1, j + 1));
            }
        }
        return ans;
    }
}