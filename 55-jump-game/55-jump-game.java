class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] possible= new boolean[n];
        possible[n-1]=true;
        
        for(int i = n-2;i>=0;i--){
            for(int j = i;j<n && j<=i+nums[i] ; j++){
                if(possible[j]){
                    possible[i] = true;
                    break;
                }
            }
        }
        
        return possible[0];
    }
}