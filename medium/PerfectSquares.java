class Solution {
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList();
        HashSet<Integer> visited = new HashSet();
        int steps = 0;
        q.offer(n);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int current = q.poll();
                if (current == 0)
                    return steps;
                for (int j = 1; j <= current / j; j++) {
                    if (!visited.contains(current - j * j)) {
                        q.offer(current - j * j);
                        visited.add(current - j * j);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}