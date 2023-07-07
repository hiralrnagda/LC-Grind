class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        List<Integer> res = new ArrayList();
        while(top <= bottom && left <= right)
        {
            //left to right while top is constant
            for(int i = left; i <= right; i++)
            {
                res.add(matrix[top][i]);
            }
            top++;
            
            //top to bottom while right is constant
            for(int i = top; i <= bottom; i++)
            {
                res.add(matrix[i][right]);
            }
            right--;
            
            //right to left while bottom is constant
            if(top <= bottom)
            {
                for(int i = right; i >= left; i--)
                {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            //bottom to top while left is constant
            if(left <= right)
            {
                for(int i = bottom; i >= top; i--)
                {
                    res.add(matrix[i][left]);
                }
                left++;
            }
                
        }
        return res;
    }
}