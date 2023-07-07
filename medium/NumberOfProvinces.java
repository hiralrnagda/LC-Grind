class Solution {
    private void dfs(int node, int[][] isConnected, int visited[]) {
        visited[node] = 1;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && visited[i] == 0) {
                dfs(i, isConnected, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        // x is connected to y => means a path exists between x and y -> graph
        // number of provinces = number of connected components
        int n = isConnected.length;
        int visited[] = new int[n];
        Arrays.fill(visited, 0);
        int counter = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                counter++;
                dfs(i, isConnected, visited); // every dfs or bfs will touch all the connected nodes
            }
        }
        return counter;
    }
}