class Solution {
    public int largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        //int i = n;
        while(n>2){
           if((nums[n-2] + nums[n-3]) > nums[n-1]){
            return nums[n-2] + nums[n-3] + nums[n-1];
           } 
           n--;
        }
        return 0;
    }
}