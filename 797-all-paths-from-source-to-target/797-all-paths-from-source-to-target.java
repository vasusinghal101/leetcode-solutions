class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        ArrayList<Integer> psf = new ArrayList<>();
        psf.add(0);
        DFS(graph,visited,0,visited.length-1,psf);
        return ans;
    }
    
    public void DFS(int[][] graph, boolean[] visited, int src, int dest, ArrayList<Integer> psf){
        if(src == dest){
            ArrayList<Integer> path = new ArrayList<>(psf);
            ans.add(path);
            return;
        }
        if(visited[src]){
            return;
        }
        visited[src] = true;
        
        for(int nbr : graph[src]){
            psf.add(nbr);
            DFS(graph, visited, nbr, dest, psf);
            psf.remove(psf.size()-1);
        }
        
        visited[src] = false;
    }
}