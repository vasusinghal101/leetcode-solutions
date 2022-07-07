class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()){
            return false;
        }
        
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
        return sol(s1,s2,s3,0,0,dp);
    }
    
    public boolean sol(String s1, String s2, String s3,int i, int j,Boolean[][] dp) {
       int k = i+j;
        
        if(k>=s3.length()){
            return true;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        char ch = s3.charAt(k);
        boolean left = false;
        boolean right = false;
        if(i < s1.length() && ch == s1.charAt(i)){
            left = sol(s1,s2,s3,i+1,j,dp);
        }
        if(j < s2.length() && ch == s2.charAt(j)){
            right = sol(s1,s2,s3,i,j+1,dp);
        }
        
        return dp[i][j] = left || right;
    }
}