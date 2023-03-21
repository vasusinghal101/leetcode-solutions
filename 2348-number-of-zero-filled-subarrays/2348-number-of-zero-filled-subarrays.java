class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                long count = 0;
                while(i<nums.length && nums[i] == 0){
                    count++;
                    i++;
                }
                //System.out.print(count);
                ans = ans+getCount(count);
            }
        }
        return ans;
        
    }
    
    public long getCount(long n){
        long np1 = n+1;
        // if(n%2==0){
        //     n=n/2;
        // }else{
        //     np1 = np1/2;
        // }
        return (n*np1)/2;
    }
}