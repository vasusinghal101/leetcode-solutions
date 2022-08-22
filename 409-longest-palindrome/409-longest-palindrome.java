class Solution {
    public int longestPalindrome(String s) {
        int[] fmap = new int[52];
        
        for(int ch : s.toCharArray()){
            if(ch < 97){
                fmap[ch-'A']++;
            }else{
                fmap[26+ch-'a']++;
            }
        }
        int ans=0;
        boolean flag=false;
        for(int n : fmap){
            if(n%2==0) ans+=n;
            else{
                flag=true;
                ans+= n-1;
            } 
        }
        if(flag) ans++;
        return ans;
    }
}