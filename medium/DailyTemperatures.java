class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Arrays.fill(res, 0);

        Deque<Integer> stack = new ArrayDeque();
        for (int currentDay = 0; currentDay < n; currentDay++) {
            int currentTemp = temperatures[currentDay];
            while (!stack.isEmpty() && temperatures[stack.peek()] < currentTemp) {
                int previousDay = stack.pop();
                res[previousDay] = currentDay - previousDay;
            }
            stack.push(currentDay);
        }

        return res;
    }
}