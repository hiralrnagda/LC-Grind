class Solution {
    public void reverseWords(char[] str) {
        String s = new String(str);
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
        for (int ind = 0; ind < ans.length(); ind++) {
            str[ind] = ans.charAt(ind);
        }
    }
}