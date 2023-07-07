/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * // Constructor initializes an empty nested list.
 * public NestedInteger();
 *
 * // Constructor initializes a single integer.
 * public NestedInteger(int value);
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list.
 * public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // Set this NestedInteger to hold a single integer.
 * public void setInteger(int value);
 *
 * // Set this NestedInteger to hold a nested list and adds a nested integer to
 * it.
 * public void add(NestedInteger ni);
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
// class Solution {
// //approach 1 - DFS
// public int depthSum(List<NestedInteger> nestedList) {
// return dfs(nestedList, 1);
// }
// private int dfs(List<NestedInteger> list, int depth){
// int total = 0;
// for(NestedInteger nested: list){
// if(nested.isInteger()){
// total += nested.getInteger() * depth;
// } else {
// total += dfs(nested.getList(), depth + 1);
// }
// }
// return total;
// }
// }

class Solution {
    // approach 2 - BFS
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> q = new LinkedList<NestedInteger>();
        q.addAll(nestedList);

        int depth = 1;
        int total = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                NestedInteger nested = q.poll();
                if (nested.isInteger()) {
                    total += nested.getInteger() * depth;
                } else {
                    q.addAll(nested.getList());
                }
            }
            depth++;
        }
        return total;

    }
}