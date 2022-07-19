class Solution {
    public int[] productExceptSelf(int[] nums) {
        boolean z = false;
        
        int p = 1;
        for(int n :nums){
            if(n==0){
                if(!z){
                    z=true;
                    continue;
                }
            }
            p*=n;
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[i]= !z ? p/nums[i] : 0;
            }else{
                nums[i] = p;
            }
        }
        
        return nums;
    }
}