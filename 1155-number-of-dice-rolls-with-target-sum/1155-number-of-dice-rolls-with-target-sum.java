class Solution {
    static int MOD = 1000000000 + 7;
    public int numRollsToTarget(int n, int k, int target) {
       Integer[][] dp = new Integer[n+1][target+1];
        return numRollsToTarget(n, k, target, dp);
    }
    
    public int numRollsToTarget(int n, int k, int target, Integer[][] dp) {
        if(n==0 && target==0) return 1;
        
        if(n<=0 || target<=0) return 0;
        
        if(dp[n][target]==null){
            int ans=0;
            for(int i=1;i<=k;i++){
                ans = (ans%MOD + numRollsToTarget(n-1, k, target - i,dp)%MOD)%MOD;
            }
            dp[n][target] = ans;
        }
        return dp[n][target];
    }
}