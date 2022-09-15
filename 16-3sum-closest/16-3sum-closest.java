class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = target + 100000;
        for(int i=0;i<nums.length-2;i++){
            int s = twoSumClosest(nums, target-nums[i], i+1);
            int num  =  nums[i] + s;
             if(Math.abs(target-ans)>Math.abs(target-num)) ans = num;
        }
        return ans;
    }
    
    public int twoSumClosest(int[] nums, int target, int l){
        int r = nums.length - 1;
        int ans = target + 100000;
        while(l<r){
            int s = nums[l]+nums[r];
            if(Math.abs(target-ans)>Math.abs(target-s)) ans = s;
            if(s==target) return target;
            else if(s>target) r--;
            else l++;
        }
        
        return ans;
    }
}