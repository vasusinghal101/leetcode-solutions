class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0) break;
            if(i==0 || nums[i]!=nums[i-1]){
            ArrayList<int[]> indexes = twoSum(nums, -1*nums[i], i+1);
            if(indexes.size()>0){
                for(int[] index : indexes)
                    ans.add(new ArrayList<Integer>(List.of(nums[i],index[0],index[1])));
            }
            }
        }
        
        return ans;
    }
    
    public ArrayList<int[]> twoSum(int[] nums, int sum, int l){
        int r = nums.length - 1;
        ArrayList<int[]> ans = new ArrayList<>();
        while(l<r){
            int s = nums[l]+nums[r];
            if(s==sum){
                ans.add(new int[]{nums[l],nums[r]});
                l++;
                while(l<r && nums[l]==nums[l-1])l++;
                r--;
            }
            else if(s>sum) r--;
            else l++;
        }
        
        return ans;
    }
}