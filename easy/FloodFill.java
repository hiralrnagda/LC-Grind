class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        if (color != initialColor) {
            runDFS(image, sr, sc, color, initialColor);
        }
        return image;
    }

    private void runDFS(int image[][], int r, int c, int newColor, int initialColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length)
            return;
        if (image[r][c] == initialColor) {
            image[r][c] = newColor;
            runDFS(image, r - 1, c, newColor, initialColor);
            runDFS(image, r + 1, c, newColor, initialColor);
            runDFS(image, r, c - 1, newColor, initialColor);
            runDFS(image, r, c + 1, newColor, initialColor);
        }
    }
}