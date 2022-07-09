class Solution {
    public int maxResult(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        
        int[] store = new int[2];
        store[0] = nums[0];
        pq.add(store);
        
        for(int i = 1; i < nums.length;i++){    
            int[] t = new int[2];
            t[1]=i;
            while(pq.peek()[1]<i-k){
                pq.poll();
            }
            t[0]=nums[i]+pq.peek()[0];
            if(i==nums.length-1){
                return t[0];
            }
            pq.add(t);
        }
        return store[0];
    }
    // public int maxResult(int[] nums, int k) {//n*k
    //     Integer[] dp = new Integer[nums.length];
    //     return maxResult(nums, k, 0,dp);
    // }
//     public int maxResult(int[] nums, int k, int idx, Integer[] dp) {
//         if(idx==nums.length-1){
//             return nums[idx];
//         }
//         if(dp[idx]!=null){
//             return dp[idx];
//         }
//         int max=-1000000000;
//         for(int i = idx+1 ,count=1; i<nums.length&&count<=k;i++,count++){
//             max = Math.max(max,maxResult(nums,k,i,dp));
//         }
        
//         return dp[idx]=max+nums[idx];
//     }
}