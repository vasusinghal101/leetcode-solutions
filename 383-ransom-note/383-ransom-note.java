class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] mmap = new int[26];
        //int[] rmap = new int[26];
        for(char ch : magazine.toCharArray()) mmap[ch-'a']++;
        for(char ch : ransomNote.toCharArray()) mmap[ch-'a']--;
        
        for(int n : mmap) {
            if(n<0) return false;
        }
        
        
        return true;
    }
}