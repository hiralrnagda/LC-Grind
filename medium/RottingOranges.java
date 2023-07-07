class Solution {
    class Pair {
        int i; // x co-ordinate
        int j; // y co-ordinate
        int t; // time

        public Pair(int i, int j, int t) {
            this.i = i;
            this.j = j;
            this.t = t;
        }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<Pair> queue = new LinkedList<Pair>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j, 0)); // add rotten oranges to queue
                } else if (grid[i][j] == 1) {
                    fresh++; // track the count of fresh oranges
                }
            }
        }

        int count = 0;
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!queue.isEmpty() && fresh != 0) {
            count += 1;
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                int r = queue.peek().i;
                int c = queue.peek().j;
                int t = queue.peek().t;
                queue.remove();
                for (int[] dir : dirs) {
                    int x = r + dir[0];
                    int y = c + dir[1];
                    if (0 <= x && x < m && 0 <= y && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer(new Pair(x, y, t + 1));
                        fresh -= 1;
                    }
                }
            }
        }

        return fresh == 0 ? count : -1;
    }
}