class Solution {
    public int rob(int[] nums) {
        int inc = nums[0];
        int exc = 0;
        
        for(int i=1;i<nums.length;i++){
            int t =exc;
           exc = Math.max(exc, inc);
           inc = t + nums[i];
        }
        
        return Math.max(exc, inc);
    }
}