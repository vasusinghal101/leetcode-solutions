class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            
            public int compare(int[] left,int[] right){
                
                return(right[0]*right[0]+right[1]*right[1])-(left[0]*left[0]+left[1]*left[1]);
            }
        });
        
        for(int[] arr:points){
            pq.add(arr);
            
            if(pq.size()>K){
                pq.poll();
            }
        }
        
        int[][] result = new int[K][2];
        while (K > 0)
            result[--K] = pq.poll();
        
        return result;
    }
}