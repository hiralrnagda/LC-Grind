class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack();
        int curnum = 0;
        String curstr = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                st.push(curstr);
                st.push("" + curnum);
                curnum = 0;
                curstr = "";
            } else if (s.charAt(i) == ']') {
                int num = Integer.parseInt(st.pop());
                String str = st.pop();
                curstr = str + curstr.repeat(num);
            } else if (Character.isDigit(s.charAt(i))) {
                curnum = curnum * 10 + Integer.parseInt("" + s.charAt(i));
            } else {
                curstr += s.charAt(i);
            }

        }
        return curstr;
    }
}