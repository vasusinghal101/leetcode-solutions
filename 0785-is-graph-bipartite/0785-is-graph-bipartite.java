class Solution {
    
    public boolean DFS(int src, int[][] graph, int level,int[] visited){
        if(visited[src]!=-1){
            if(level%2 == visited[src]){
                return true;
            }else{
                return false;
            }
        }
        
        visited[src] = level%2;
        
        for(int nbr : graph[src]){
            if(!DFS(nbr,graph,level+1,visited)){
                return false;
            }
            
        }
        
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        Arrays.fill(visited,-1);
        
        for(int i=0;i<visited.length;i++){
            if(visited[i]==-1 && !DFS(i,graph,0,visited))
                return false;
        }
        return true;
//         int n = graph.length;
//         int[] color = new int[n];
//         Arrays.fill(color, -1);

//         for (int start = 0; start < n; ++start) {
//             if (color[start] == -1) {
//                 Stack<Integer> stack = new Stack();
//                 stack.push(start);
//                 color[start] = 0;

//                 while (!stack.empty()) {
//                     Integer node = stack.pop();
//                     for (int nei: graph[node]) {
//                         if (color[nei] == -1) {
//                             stack.push(nei);
//                             color[nei] = color[node] ^ 1;
//                         } else if (color[nei] == color[node]) {
//                             return false;
//                         }
//                     }
//                 }
//             }
//         }

//         return true;
    }}