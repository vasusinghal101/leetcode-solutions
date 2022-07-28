class Solution {
    public boolean validPath(int n, int[][] edges, int src, int des) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        
        for(int i=0;i<n;i++){
            graph[i]= new ArrayList<>();
        }
        
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        
        //return dfs(graph, src, des,visited);
         return dfs(graph, src, des,visited);
        
    }
     public boolean bfs(ArrayList<Integer>[] graph,int src, int dest){
         boolean[] visited = new boolean[graph.length];
         Queue<Integer> q = new ArrayDeque<>();
         q.add(src);
         
         while(q.size()>0){
             int front = q.remove();
             if(visited[front]) continue;
             
             //visited[front] = true;
             
             for(int nbr : graph[src]){
                 if(nbr == dest) return true;
                 visited[nbr] = true;
                 q.add(nbr);
             }
         }
         
         return false;
     }
    public boolean dfs(ArrayList<Integer>[] graph,int source, int destination, boolean[] visited){
        if(source==destination){
            return true;
        }
        
        for(Integer nbr : graph[source]){
            if(visited[nbr]){
                continue;
            }
            visited[nbr]=true;
            boolean ans = dfs(graph,nbr,destination,visited);
            if(ans){
                return true;
            }
        }
        return false;
    }
}