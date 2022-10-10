class Solution {
    public String breakPalindrome(String p) {
        if(p.length()==1) return "";
        
        char[] s = p.toCharArray();
        int np = p.length()%2==0 ? p.length() : p.length()/2;
        int i;
        for(i=0;i<p.length();i++){
            if(s[i]=='a' || np == i) continue;
            
            s[i]='a';
            break;
        }
        
        if(i==p.length())s[i-1]++;
        return new String(s);
    }
}