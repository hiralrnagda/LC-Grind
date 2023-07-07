class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0)
            return;
        int rows = rooms.length;
        int columns = rooms[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (rooms[i][j] == 0) // BFS on each gate
                {
                    queue.add(new int[] { i, j });
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            int row = top[0], col = top[1];
            if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) // up
            {
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.add(new int[] { row - 1, col });
            }
            if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) // down
            {
                rooms[row + 1][col] = rooms[row][col] + 1;
                queue.add(new int[] { row + 1, col });
            }
            if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) // left
            {
                rooms[row][col - 1] = rooms[row][col] + 1;
                queue.add(new int[] { row, col - 1 });
            }
            if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) // right
            {
                rooms[row][col + 1] = rooms[row][col] + 1;
                queue.add(new int[] { row, col + 1 });
            }
        }
    }
}