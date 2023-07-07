class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /**
        TC - O(N K log K) sorting is K logK and loop through N strings
        SC - O(N K)
         */
        Map<String, List> map = new HashMap();

        int count[] = new int[26];
        for(String str: strs)
        {
            char s[] = str.toCharArray();
            // Arrays.sort(s);
            // String key = String.valueOf(s);

            //Alternative for sorting logic - maintain a frequency array
            Arrays.fill(count, 0);
            for(char c: str.toCharArray()){
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for(int i = 0; i < 26; i++)
            {
                sb.append(count[i]);
                sb.append("#");
            }
            String key = sb.toString();
            //uptil here
            //TC - O(N K)
            //SC - O(N K)

            if(!map.containsKey(key))
            {
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}