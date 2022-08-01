class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                
                if(i==1||j==1){
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j]=dp[i-1][j]+dp[i][j-1]; 
             }
        }
            return dp[m][n];
        
    }
    
//     public int uniquePaths_mem(int m, int n){
//         if(m<0||n<0){
//             return 0;
//         }
//         if(m==0||n==0){
//             return 1;
//         }    
//         int r = uniquePaths_mem(int m, int n-1);
//         int d = uniquePaths_mem(int m-1, int n);
        
//         return r+d;
//     }
}