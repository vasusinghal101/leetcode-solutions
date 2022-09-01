class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int n : stones){
            pq.add(n);
        }
        
        while(pq.size()>1){
            int y = pq.poll();
            int x = pq.poll();
            //System.out.println(y +" - "+x+"");
            if((y-x)>0) pq.add(y-x);
        }
        
        return pq.peek()==null?0:pq.peek();
    }
}