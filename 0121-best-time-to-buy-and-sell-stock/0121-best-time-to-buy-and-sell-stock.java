class Solution {
    public int maxProfit(int[] prices) {
        
//         int ans = 0;
//         int size = prices.length;
//         int rmax = prices[size-1];
        
//         for (int i = size-2; i >=0 ; i--){
//             if ( prices[i]>=rmax){
//                 rmax = prices[i];
//             } else{
//                 ans = Math.max(rmax-prices[i],ans);
//             }
//         }
        
//         return ans;
        
        int ans = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i=0;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            ans = Math.max(ans,prices[i]-min);
        }
        
        return ans;
    }
}