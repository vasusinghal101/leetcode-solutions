class Solution {
    public int maximumXOR(int[] nums) {
        int ans=0;
        for(int i = 0;i<32;i++){
            int mask = 1<<i;
            for(int n : nums){
             if((n&mask) > 0){
                 ans = ans| mask;
                 break;
             }
            }
        }
        return ans;
    }
}