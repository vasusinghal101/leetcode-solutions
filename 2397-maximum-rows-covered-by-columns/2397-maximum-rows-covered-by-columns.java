class Solution {
    public int maximumRows(int[][] mat, int cols) {
        int n = mat.length;
        int m = mat[0].length;
        int ans=0;
        for(int x = 0; x<= 1<<m;x++){
            int count = 0;
            int idx=x;
            HashSet<Integer> hs = new HashSet<>();
            int k = m-1;
            while(idx>0){
                if(idx%2==1) hs.add(k);
                count += idx%2;
                idx=idx/2;
                k--;
            }
            if(count!=cols) continue;
            int tans=0;
             for(int i=0;i<n;i++){
                boolean flag=true;
                for(int j=0;j<m;j++){
                    if(mat[i][j]==1 && !hs.contains(j)) flag=false;
                }
                 if(flag) tans++;
             }
            ans = Math.max(ans,tans);
        }
        return ans;
    }
}