class Solution {
    public boolean isIsomorphic(String s, String t) {
        char alpha[] = new char[257];
        boolean ar[] = new boolean[257];
        char ss[] = s.toCharArray();
        char tt[] = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (alpha[ss[i]] == 0 && ar[tt[i]] == false) {
                alpha[ss[i]] = tt[i];
                ar[tt[i]] = true;
            } else if (alpha[ss[i]] != tt[i])
                return false;
        }
        return true;
    }
}