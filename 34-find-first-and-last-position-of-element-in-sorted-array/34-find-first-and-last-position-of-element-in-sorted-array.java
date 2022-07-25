class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        
        ans[0] = first(nums,target);
        ans[1] = last(nums,target);
        
        return ans;
    }
    
    public int first(int[] arr, int target){
        if(arr.length==0){
            return -1;
        }
        
        int left=0;
        int right=arr.length-1;
        
        while(left<right){
            int mid = left+(right-left)/2;
            if(arr[mid] == target){
                right=mid;
            }else if(arr[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        
        right = (right>=0 && arr[right]==target) ? right : -1;
        
        return right;
    }
    
        public int last(int[] arr, int target){
        if(arr.length==0){
            return -1;
        }
        
        int left=0;
        int right=arr.length-1;
        
        while(left<right){
            int mid = (left+(right-left+1)/2);
            if(arr[mid] == target){
                left=mid;
            }else if(arr[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        
        left = left < arr.length && arr[left]==target ? left : -1;
        
        return left;
    }
}