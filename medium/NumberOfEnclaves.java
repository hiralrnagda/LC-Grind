class Solution {
    private void bfs(int x, int y, int m, int n, int[][] grid, boolean[][] visit) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { x, y });
        visit[x][y] = true;

        int[] dirx = { 0, 1, 0, -1 };
        int[] diry = { -1, 0, 1, 0 };

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            x = temp[0]; // row nnumber
            y = temp[1]; // column number

            for (int i = 0; i < 4; i++) {
                int r = x + dirx[i];
                int c = y + diry[i];
                if (r < 0 || r >= m || c < 0 || c >= n) {
                    continue;
                } else if (grid[r][c] == 1 && !visit[r][c]) {
                    q.offer(new int[] { r, c });
                    visit[r][c] = true;
                }
            }
        }
        return;
    }

    public int numEnclaves(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            // first column
            if (grid[i][0] == 1 && !visit[i][0]) {
                bfs(i, 0, m, n, grid, visit);
            }
            // last column
            if (grid[i][n - 1] == 1 && !visit[i][n - 1]) {
                bfs(i, n - 1, m, n, grid, visit);
            }
        }
        for (int j = 0; j < n; j++) {
            // first row
            if (grid[0][j] == 1 && !visit[0][j]) {
                bfs(0, j, m, n, grid, visit);
            }
            // last row
            if (grid[m - 1][j] == 1 && !visit[m - 1][j]) {
                bfs(m - 1, j, m, n, grid, visit);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visit[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}