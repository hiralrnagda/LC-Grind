class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. store the number -> freq in a map
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2. build a heap of frequencies from the map - min heap
        PriorityQueue<Integer> heap = new PriorityQueue((a, b) -> map.get(a) - map.get(b));
        for (int num : map.keySet()) {
            heap.add(num);
            if (heap.size() > k)
                heap.poll();
        }

        // 3. pop top k frequent elements from the heap - return that in array
        for (int i = k - 1; i >= 0; i--) {
            res[i] = heap.poll();
        }
        return res;
    }
}