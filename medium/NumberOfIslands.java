class Solution {
    // Approach 1: DFS and also not visited[][], and modifying existing matrix
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') { // this if is executed exactly # of islands times -
                    count++;
                    runBFS(grid, i, j);
                }
            }
        }
        return count;
    }

    private void runDFS(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        runDFS(grid, i - 1, j);// up
        runDFS(grid, i + 1, j);// down
        runDFS(grid, i, j - 1);// left
        runDFS(grid, i, j + 1);// right
    }
}