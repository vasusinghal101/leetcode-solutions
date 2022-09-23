class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        ArrayList<Integer>[] g = new ArrayList[n];
        for(int i=0;i<n;i++) g[i] = new ArrayList<Integer>();
        
        for(int[] edge : edges){
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }
        
        boolean[] isrestricted = new boolean[n];
        for(int idx:restricted) isrestricted[idx] = true;
        
        HashSet<Integer> visited = new HashSet<>();
        dfs(0,g,visited,isrestricted);
        
        return visited.size();
    }
    
    public void dfs(int src, ArrayList<Integer>[] g, HashSet<Integer> visited, boolean[] isr){
        if(visited.contains(src)) return;
        
        visited.add(src);
        
        for(int nbr: g[src]){
            if(!isr[nbr]) dfs(nbr, g, visited, isr);
        }
    }
}