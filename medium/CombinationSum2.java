class Solution {
    private void findCombinations(int ind, int a[], int target, List<List<Integer>> ans, List<Integer> ds){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
            
        for(int i = ind; i < a.length; i++){
            if(i > ind && a[i] == a[i - 1]) { //here i > ind - because if 2 duplicates are present then 1st is picked
                continue;
            }
            if(a[i] > target) {
                break;
            }
            
            ds.add(a[i]);
            findCombinations(i + 1, a, target - a[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, ans, new ArrayList());
        return ans;
    }
}