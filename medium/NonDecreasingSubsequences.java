class Solution {
    private void solve(int ind, int nums[], List<Integer> ds, Set<List<Integer>> res) {
        if (ind == nums.length) {
            if (ds.size() > 1) {
                res.add(new ArrayList(ds));
            }
            return;
        }

        int prev = ds.size() == 0 ? -101 : ds.get(ds.size() - 1);

        if (nums[ind] >= prev) {
            ds.add(nums[ind]);
            solve(ind + 1, nums, ds, res);
            ds.remove(ds.size() - 1);
            /**
             * After the recursive call, we remove the last element from the subsequence
             * (ds.remove(ds.size() - 1)) to backtrack and explore other possibilities, and
             * then we recursively call solve with the next index without adding the current
             * element to the subsequence.
             * 
             */
            solve(ind + 1, nums, ds, res);
        } else {
            /**
             * If the current element is not greater than or equal to the previous element,
             * we skip adding it to the subsequence and recursively call solve with the next
             * index.
             */
            solve(ind + 1, nums, ds, res);
        }
    }

    private void solve2(int ind, int nums[], List<Integer> ds, Set<List<Integer>> res) {
        if (ds.size() >= 2) {
            res.add(new ArrayList(ds));
        }
        if (ind == nums.length) {
            return;
        }

        int prev = ds.size() == 0 ? -101 : ds.get(ds.size() - 1);

        for (int i = ind; i < nums.length; i++) {
            if (ds.size() == 0 || prev <= nums[i]) {
                ds.add(nums[i]);
                solve2(i + 1, nums, ds, res);
                ds.remove(ds.size() - 1);
            }
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        List<Integer> ds = new ArrayList();
        // solve(0, nums, ds, res);
        solve2(0, nums, ds, res);
        return new ArrayList(res);
    }
}