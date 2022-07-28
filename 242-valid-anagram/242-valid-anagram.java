class Solution {
    public boolean isAnagram(String s, String t) {
        int[] fmap = new int[26];
        
        for(char ch : s.toCharArray()){
            fmap[ch-'a']++;
        }
        
        for(char ch : t.toCharArray()){
            fmap[ch-'a']--;
        }
        
        for(int i=0;i<26;i++){
            if(fmap[i]!=0)return false;
        }
        
        return true;
    }
}