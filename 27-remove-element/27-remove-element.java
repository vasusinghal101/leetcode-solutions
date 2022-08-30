class Solution {
    public int removeElement(int[] nums, int val) {
        int l=0;
        int r=nums.length-1;
        //if(r<0) return 0;
        while(l<=r){
            if(nums[l] == val){
                nums[l]=nums[r];
                r--;
            }else{
                l++;
            }
        }
        return l;
    }
}