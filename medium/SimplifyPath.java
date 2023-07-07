class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        String []p = path.split("/");

        for(int i = 0; i < p.length; i++)
        {
            //equals() - check for exact match
            //contains() - filters out if your specified string is part the string you referenced to
            if(!stack.isEmpty() && p[i].equals(".."))
            {
                stack.pop();
            }
            else if(!p[i].equals("") && !p[i].equals(".") && !p[i].                 equals(".."))
            {
                stack.push(p[i]);
            }
        }

        if(stack.isEmpty()) return "/";

        String res = "";
        while(!stack.isEmpty())
        {
            res= "/" + stack.pop() + res;
        }
        return res;
    }
}