class Solution {
    public void rotate(int[][] matrix) {
        //transpose the matrix and reverse the transposed matrix
        int n = matrix.length;

        //transpose
        for(int i = 0; i < n; i++)
        {
            for(int j = i; j < n; j++)
            {
                int t = 0;
                t = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = t;
            }
        }

        //reverse
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n/2; j++)
            {
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = t;
            }
        }
    }
}