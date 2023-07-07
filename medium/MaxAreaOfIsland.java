class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    result = Math.max(
                            dfs(grid, i, j, m, n, new int[] { 0 }),
                            result);
                }
            }
        }
        return result;
    }

    private int dfs(int[][] grid, int i, int j, int m, int n, int[] count) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0)
            return 0;

        count[0]++;
        grid[i][j] = 0;
        dfs(grid, i - 1, j, m, n, count);// up
        dfs(grid, i + 1, j, m, n, count);// down
        dfs(grid, i, j - 1, m, n, count);// left
        dfs(grid, i, j + 1, m, n, count);// right
        return count[0];
    }
}