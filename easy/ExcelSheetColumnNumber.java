class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;

        int n = columnTitle.length();
        for (int i = 0; i < n; i++) {
            result *= 26;
            result += (columnTitle.charAt(i) - 'A' + 1);
        }
        return result;
    }
}