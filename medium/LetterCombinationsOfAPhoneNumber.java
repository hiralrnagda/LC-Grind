class Solution {
    private void helper(int n, String str, String charMap[], List<String> result)
    {
        if(n == 0){
            result.add(str);
            return;
        }

        int n1 = n % 10;
        String str1 = charMap[n1];
        for(int i = 0; i < str1.length(); i++)
        {
            helper(n/10, str1.charAt(i)+str, charMap, result);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits.length() == 0) return result;
        int n = Integer.parseInt(digits);
        String charMap[] = new String[]
        {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv", "wxyz"};
        helper(n, "", charMap, result);
        return result;
    }
}
