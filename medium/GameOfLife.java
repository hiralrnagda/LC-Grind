class Solution {
    // the only trick is to denote live --> die as -1 and die --> live as 2
    public void gameOfLife(int[][] board) {
        int dx[] = new int[] { 0, 0, 1, 1, 1, -1, -1, -1 };
        int dy[] = new int[] { 1, -1, 1, -1, 0, 0, 1, -1 };
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveCount = 0;

                // this part gets the count of alive neighbours
                for (int t = 0; t < 8; t++) {
                    int newx = i + dx[t];
                    int newy = j + dy[t];

                    if (newx >= 0 && newx < m && newy >= 0 && newy < n) {
                        if (Math.abs(board[newx][newy]) == 1) {
                            liveCount++;
                        }
                    }
                }

                if (board[i][j] % 2 == 0) { // ded to live => respresented as 2
                    if (liveCount == 3) {
                        board[i][j] = 2;
                    }
                } else {
                    if (!(liveCount >= 2 && liveCount <= 3)) {
                        board[i][j] = -1;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
            }
        }
    }
}