class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] minCount= new int[n];
        minCount[n-1]=0;
        
        for(int i = n-2;i>=0;i--){
            int ans = 10000000+7;
            for(int j = i+1;j<n && j<=i+nums[i] ; j++){
                    ans = Math.min(ans, minCount[j]+1); 
            }
            minCount[i] = ans;
        }

        return minCount[0];
    }
}