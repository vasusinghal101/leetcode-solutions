class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int sum = 0;
        int ans = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        
        for(int val:nums){
            sum+=val;//prefix sum
            
            ans+=hm.getOrDefault(sum-k,0);//update result based on 0-(i-1) sum available
            
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        
        return ans;
    }
}