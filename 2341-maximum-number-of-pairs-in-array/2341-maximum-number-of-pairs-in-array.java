class Solution {
    public int[] numberOfPairs(int[] nums) {
        HashMap<Integer,Integer> fmap = new HashMap<>();
        
        for(int n:nums){
            fmap.put(n,fmap.getOrDefault(n,0)+1);
        }
        
        int[] ans = new int[2];
        
        for(int n : fmap.keySet()){
            int f = fmap.get(n);
            ans[0] += f/2;
            ans[1] += f%2;
        }
        
        return ans;
    }
}