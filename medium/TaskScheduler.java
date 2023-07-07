class Solution {
    // Approach 1 - heap - intuitive
    public int leastInterval(char[] tasks, int n) {
        if (n == 0)
            return tasks.length;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> b - a);
        // Pair -> task, idle_time
        Queue<Pair<Integer, Integer>> q = new LinkedList();
        int count[] = new int[26];

        // counting freq of tasks
        for (char c : tasks) {
            count[c - 'A']++;
        }
        // build a maxHeap
        for (int val : count) {
            if (val > 0) {
                heap.add(val);
            }
        }
        int time = 0;
        while (!heap.isEmpty() || !q.isEmpty()) {
            time = time + 1;
            // processing the heap
            if (!heap.isEmpty()) {
                int val = heap.poll();
                val--;
                if (val > 0)// add time to queue with updated idle time
                {
                    q.add(new Pair(val, n + time));
                }
            }

            // processing queue
            if (!q.isEmpty() && q.peek().getValue() == time) {
                heap.add(q.poll().getKey());
            }
        }
        return time;
    }

    // Approach 2 - Math
    // public int leastInterval(char[] tasks, int n) {
    // int[] count = new int[26];
    // for(char c: tasks){
    // count[c - 'A']++;
    // }
    // // max frequency
    // int f_max = 0;
    // for (int f : count) {
    // f_max = Math.max(f_max, f);
    // }
    // // count the most frequent tasks
    // int n_max = 0;
    // for (int f : count) {
    // if (f == f_max) n_max++;
    // }
    // return Math.max(tasks.length, (f_max - 1)* (n + 1) + n_max);
    // }
}