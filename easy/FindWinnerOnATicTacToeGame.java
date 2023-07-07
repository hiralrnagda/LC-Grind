class Solution {
    private int board[][];
    private int n = 3;

    public String tictactoe(int[][] moves) {
        board = new int[n][n];
        int player = 1;

        // for each move
        for (int move[] : moves) {
            int row = move[0];
            int col = move[1];

            board[row][col] = player;

            // after every move check if the current player is winning
            if (checkRow(row, player) || checkCol(col, player) ||
                    (row == col && checkDiagonal(player) ||
                            (row + col == n - 1 && checkAntiDiagonal(player)))) {
                return player == 1 ? "A" : "B";
            }

            // if no one wins at this point - let the other player play
            player *= -1;
        }

        // if all moves are done
        return moves.length == n * n ? "Draw" : "Pending";
    }

    private boolean checkRow(int row, int player) {
        for (int col = 0; col < n; col++) {
            if (board[row][col] != player)
                return false;
        }
        return true;
    }

    private boolean checkCol(int col, int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][col] != player)
                return false;
        }
        return true;
    }

    private boolean checkDiagonal(int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][row] != player)
                return false;
        }
        return true;
    }

    private boolean checkAntiDiagonal(int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][n - 1 - row] != player)
                return false;
        }
        return true;
    }
}