class Solution {
    private void findPartitions(int index, List<List<String>> ans, String s, List<String> ds) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                ds.add(s.substring(index, i + 1));
                findPartitions(i + 1, ans, s, ds);
                ds.remove(ds.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList();
        findPartitions(0, ans, s, new ArrayList());
        return ans;
    }
}