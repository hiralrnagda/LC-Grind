class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 0 || mat[0].length == 0)
            return new int[0];

        int m = mat.length;
        int n = mat[0].length;
        int total = m * n;
        int result[] = new int[total];

        int i = 0, row = 0, col = 0;
        boolean up = true;

        while (i < total) {
            // diagonal is moving upwards
            if (up) {
                while (row > 0 && col < n - 1) {
                    result[i++] = mat[row][col];
                    row--;
                    col++;
                }
                result[i++] = mat[row][col];
                if (col == n - 1) {
                    row++;
                } else {
                    col++;
                }
            }
            // diagonal is moving downwards
            else {
                while (col > 0 && row < m - 1) {
                    result[i++] = mat[row][col];
                    ;
                    row++;
                    col--;
                }
                result[i++] = mat[row][col];
                if (row == m - 1) {
                    col++;
                } else {
                    row++;
                }
            }
            up = !up;
        }

        return result;
    }
}