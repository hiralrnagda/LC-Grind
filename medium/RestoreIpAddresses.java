class Solution {
    private void solve(int index, String s, List<String> res, List<String> ds){
        //base condition
        if(index == s.length() && ds.size() == 4)
        {
            res.add(String.join(".", ds));
            return;
        }

        for(int i = 1; i <= 3; i++)
        {
            if(index + i > s.length()) return;

            String sb = s.substring(index, index + i);
            
            //check if first character is not 0 and string integer value is not gte 256
            if(!(sb.length() > 1 && sb.charAt(0) == '0' || Integer.parseInt(sb) > 255 )){
                ds.add(sb);
                // move i index forward and call backtrack on that
                solve(index + i, s, res, ds); 
                ds.remove(ds.size() - 1);
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<String>();
        if(s.length() > 12) return res;
        solve(0, s, res, new ArrayList());
        return res;
    }
}