class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        
        int esum = 0;
        
        for(int n : nums){
            if(n%2==0) esum+=n;
        }
        
        int i=0;
        for(int[] query : queries){
            int idx = query[1];
            int oval = nums[idx];
            
            int nval = oval + query[0];
            
            if(nval%2==0){
                if(oval%2==0){
                    esum+=query[0];
                }else{
                    esum+=nval;
                }
            }else{
                if(oval%2==0){
                    esum-=oval;
                }
            }
            
            ans[i] = esum;i++;
            nums[idx] = nval;
        }
        
        return ans;
    }
}