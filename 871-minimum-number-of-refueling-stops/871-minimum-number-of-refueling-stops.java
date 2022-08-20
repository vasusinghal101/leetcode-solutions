class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel>=target){
            return 0;
        }
        
        int i = 0;
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(startFuel<target){
            while( i<stations.length && startFuel>=stations[i][0] ){
                pq.add(stations[i][1]);
                i++;
            }
            if(pq.size()>0){
                int fuel = pq.remove();
                count++;
                startFuel+=fuel;
            }else{
                return -1;
            }
        }
        
        return count;
        
    }
}