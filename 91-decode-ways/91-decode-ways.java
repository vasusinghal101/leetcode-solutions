class Solution {
    public int numDecodings(String s) {
        for(int i =0;i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '0'){
                if(i ==0 || (s.charAt(i-1)!='1' && s.charAt(i-1)!='2')) return 0;
            }
        }
        int[] dp = new int[s.length()];
        return helper(s, 0, dp);
    }
    
    
    public int helper(String s, int i, int[] dp){
        if(i>=s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(i == s.length()-1) return 1;
        int ans = 0;
        if(dp[i]!=0) return dp[i];
        if(s.charAt(i+1) != '0')
        ans += helper(s,i+1, dp);
        if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6'))
        ans += helper(s,i+2, dp);
        dp[i] = ans;
        return ans;
    }
}