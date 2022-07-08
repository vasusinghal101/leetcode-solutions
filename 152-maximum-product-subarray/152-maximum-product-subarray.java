class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int max = nums[0];
        int min = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] == 0){
                max=0;
                min=0;
                ans = Math.max(nums[i],ans);
            }else{
                int tmax = Math.max(nums[i],Math.max(max*nums[i],min*nums[i]));
                min = Math.min(nums[i],Math.min(min*nums[i],max*nums[i]));
                max=tmax;
                //System.out.println(max+""+min+"arr"+nums[i]);
                ans = Math.max(ans,max);
            }
        }
        
        return ans;
    }
}