class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        long csum = 0;
        int size = chargeTimes.length;
        int si = 0;
        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        for(int i=0; i<size;i++){
            csum += runningCosts[i];
            pq.add(new int[]{chargeTimes[i], i});
            
            int highest = getHighest(pq,si);
            long cost = highest + (i-si+1)*csum;
            
            while(cost>budget && si<=i){
                csum -= runningCosts[si];
                si++;
                highest = getHighest(pq,si);
                cost = highest + (i-si+1)*csum;    
            }
            
            ans = Math.max(ans, i-si+1);
        }
        
        return ans;
    }
    
    public int getHighest(PriorityQueue<int[]> pq, int si){
        while(pq.size()>0 && pq.peek()[1]<si){
            pq.poll();
        }
        
        return pq.size()==0 ? 0 : pq.peek()[0];
    }
}