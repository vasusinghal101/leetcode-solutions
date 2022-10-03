class Solution {
    public int minCost(String colors, int[] nT) {
        int ans = 0;
        int count = 1;
        int max = nT[0];
        int sum = nT[0];
        
        for(int i=1; i<colors.length();i++){
            if(colors.charAt(i)==colors.charAt(i-1)){
                count++;
                sum+=nT[i];
                max = Math.max(max, nT[i]);
            }else{
                if(count>1){
                    ans+= sum-max;
                }
                count =1;
                max=nT[i];
                sum = nT[i];
            }
        }
        if(count>1){
            ans+= sum-max;
        }
        
        return ans;
    }
}