class Solution {
    public int maxScore(int[] cp, int k) {
        
        int ans = 0;
        for(int i=0;i<k;i++){
            ans+=cp[i];
        }
        
        int temp = ans;
        
        for(int i=cp.length-1, j=k-1;i>=cp.length-k;i--,j--){
            temp = temp-cp[j];
            temp+=cp[i];
            ans=Math.max(ans,temp);
        }
            
            
        return ans;
    }
}