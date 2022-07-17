class Solution {
    // Integer[][] memo = new Integer[1001][1001];
    public int kInversePairs(int n, int k) {
        // if (n == 0)
        //     return 0;
        // if (k == 0)
        //     return 1;
        // if (memo[n][k] != null)
        //     return memo[n][k];
        // int inv = 0;
        // for (int i = 0; i <= Math.min(k, n - 1); i++)
        //     inv = (inv + kInversePairs(n - 1, k - i)) % 1000000007;
        // memo[n][k] = inv;
        // return inv;
        
         int[][] dp = new int[n + 1][k + 1];
        int M = 1000000007;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0)
                    dp[i][j] = 1;
                else {
                    int val = (dp[i - 1][j] + M - ((j - i) >= 0 ? dp[i - 1][j - i] : 0)) % M;
                    dp[i][j] = (dp[i][j - 1] + val) % M;
                }
            }
        }
        return ((dp[n][k] + M - (k > 0 ? dp[n][k - 1] : 0)) % M);
        
    }
}