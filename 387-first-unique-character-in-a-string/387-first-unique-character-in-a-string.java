class Solution {
    public int firstUniqChar(String s) {
        int[] letter = new int[26];
        int ans = -1;
        for(int i = s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            letter[ch-'a']++; 
        }
        
        for(int i =0 ;i<s.length();i++){
             char ch = s.charAt(i);
             if(letter[ch-'a']==1) return i; 
        }
        
        return ans;
    }
}