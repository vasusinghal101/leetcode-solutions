class Solution {
    public int concatenatedBinary(int n) {
        int mod = 1000000007;
        int cb=0;
        long ans=0;
        for(int i=1; i<=n; i++){
            int rsb = i&(-i);
            if(rsb==i) cb++;
            //System.out.println(ans+ "-" + cb);
            ans = ans<<cb;
            //System.out.println(ans+ "-" + cb);
            ans = ((ans)+i)%mod;
        }
        
        return (int)ans;
    }
}