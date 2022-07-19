class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean[] visited = new boolean[isConnected.length];
        
        for(int i =0;i<visited.length;i++){
            if(!visited[i]){
                count++;
                gcc(isConnected,i,visited);
            }
        }
        
        return count;
    }
    
    public void gcc(int[][] graph, int src, boolean[] visited){
        if(visited[src]){
            return;
        }
        
        visited[src] = true;
        
        for(int i=0;i<graph[0].length;i++){
            if(graph[src][i]==1){
                gcc(graph,i,visited);
            }
        }
    }
}