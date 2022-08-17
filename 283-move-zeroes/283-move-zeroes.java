class Solution {
    public void moveZeroes(int[] nums) {
//         int l = 0;
//         for(int i = 0; i<nums.length;i++){
//             if(nums[i]!=0){
//                 nums[l]=nums[i];
//                 l++;
//             }
//         }
        
//         for(int i = l;i<nums.length;i++)
//             nums[i]=0;
         int snowBallSize = 0; 
        for (int i=0;i<nums.length;i++){
	        if (nums[i]==0){
                snowBallSize++; 
            }
            else if (snowBallSize > 0) {
	            int t = nums[i];
	            nums[i]=0;
	            nums[i-snowBallSize]=t;
            }
        }
    }
}