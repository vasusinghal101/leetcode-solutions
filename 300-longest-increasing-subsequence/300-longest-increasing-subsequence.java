class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        
        dp[0] = 1;
        int ans=1;
        for(int i=1; i<nums.length;i++){
            int eat = 0;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j])eat = Math.max(eat,dp[j]);
            }
            dp[i]=eat+1;
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
}