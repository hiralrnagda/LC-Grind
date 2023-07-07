class Solution {
    
    public List<String> generateParenthesis(int n) 
    {
        List<String> result = new ArrayList<String>();
        backTrack(result, "", 0, 0, n);
        return result;
    }

    private void backTrack(List<String> result, String str, int openCount, int closedCount, int n){
        if(str.length() == n*2 ){
            result.add(str);
            return;
        }

        if(openCount < n){
            backTrack(result, str+'(', openCount + 1, closedCount, n);
        }

        if(closedCount < openCount){
            backTrack(result, str+')', openCount, closedCount + 1, n);
        }
    }
}