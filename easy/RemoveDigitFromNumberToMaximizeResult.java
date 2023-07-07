class Solution {
    public String removeDigit(String number, char digit) {
        List<String> digits = new ArrayList();
        int n = number.length();
        for (int i = 0; i < n; i++) {
            if (number.charAt(i) == digit) {
                digits.add(number.substring(0, i) + number.substring(i + 1, n));
            }
        }
        Collections.sort(digits);
        return digits.get(digits.size() - 1);
    }
}