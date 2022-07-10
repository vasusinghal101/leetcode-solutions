class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int a=cost[0];
        int b=cost[1];
        
        for(int i=2;i<n;i++){
            int min = Math.min(cost[i-1],cost[i-2]);
            cost[i]+=min;
        }
        return Math.min(cost[n-1],cost[n-2]);
        
    }
    
    
}