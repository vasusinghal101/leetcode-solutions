class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(n > connections.length+1) return -1;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++) graph[i] = new ArrayList<Integer>();
        
        for(int[] e : connections){
            graph[e[0]].add(e[1]); 
            graph[e[1]].add(e[0]); 
        }
        
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                gcc(graph,visited,i);
                count++;
            }
        }
        return count-1;
    }
    
    public void gcc(ArrayList<Integer>[] graph, boolean[] visited, int src){
        if(visited[src]){
            return;
        }
        
        visited[src] = true;
        for(int nbr:graph[src]){
            gcc(graph,visited,nbr);
        }
    }
}