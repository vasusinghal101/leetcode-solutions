class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        
        int x1 = 0;
        int x2 = 0;
        for(int n : nums1){
            x1= x1^n;
        }
        for(int n : nums2){
            x2 = x2^n;
        }
        if(nums1.length%2==0 && nums2.length%2==0){
            return 0;
        }else if(nums1.length%2==0){
            return x1;
        }else if(nums2.length%2==0){
            return x2;
        }else{
            return x1^x2;
        }
    }
}