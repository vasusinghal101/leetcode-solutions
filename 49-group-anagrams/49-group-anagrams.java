class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> hm = new HashMap<>();
        
        for(String str:strs){
            int[] fmap = new int[26];
            for(char ch: str.toCharArray()) fmap[ch-'a']++;
            String f = Arrays.toString(fmap);
            if(!hm.containsKey(f)) hm.put(f, new ArrayList<String>());
            hm.get(f).add(str);
        }
        
        return new LinkedList<>(hm.values());
    }
}