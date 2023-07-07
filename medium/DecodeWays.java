class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int numDecodings(String s) {
        return solve(0, s);
    }

    private int solve(int index, String s){
        if(memo.containsKey(index)) return memo.get(index);

        if(index == s.length()){
            return 1;
        }

        if(s.charAt(index) == '0') return 0;

        //recursive call including 1st character and rest of the string
        int res = solve(index + 1, s);
        //recursive call including 1st 2 characters and rest of the string
        //checking if 2 characters together are <= 26
        if(index < s.length() - 1 && Integer.parseInt(s.substring(index, index + 2)) <= 26)
        {
            res += solve(index + 2, s);
        }

        memo.put(index, res);

        return res;
    }
}