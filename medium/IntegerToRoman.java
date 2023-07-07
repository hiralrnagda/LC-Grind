class Solution {
    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};    
    private static final String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public String intToRoman(int num) {
        // StringBuilder sb = new StringBuilder();
        // // Loop through each symbol, stopping if num becomes 0.
        // for (int i = 0; i < values.length && num > 0; i++) {
        //     // Repeat while the current symbol still fits into num.
        //     while (values[i] <= num) {
        //         num -= values[i];
        //         sb.append(symbols[i]);
        //     }
        // }
        // return sb.toString();

        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hrns = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] ths = {"", "M", "MM", "MMM"};

        return ths[num / 1000] + hrns[(num % 1000) / 100] + tens[(num % 100) / 10] + ones[num % 10];
    }
}