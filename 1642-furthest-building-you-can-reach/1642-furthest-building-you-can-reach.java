class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i<=heights.length-2;i++){
            int climb = heights[i+1]-heights[i];

            if(climb<=0){
                continue;
            }
            if(pq.size()<ladders){
                pq.add(climb);
                continue;
            }
            
            if(pq.peek()!=null && pq.peek()>=climb){
                bricks-=climb;
            }else{
                if(ladders>0){
                    int lastSmallest = pq.poll();
                    pq.add(climb);
                    bricks-=lastSmallest;
                }else{
                    bricks-=climb;
                }
            } 
 
            if(bricks<0){
                return i;
            }
        }
        
        return heights.length-1;
    }
}