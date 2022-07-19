class Solution {
    //static int count=0;
    public long dfs(ArrayList<ArrayList<Integer>> graph, int v,boolean[] visited){
            
        ArrayList<Integer> nbrs = graph.get(v);
        long count = 1;
        for(Integer n : nbrs){
            if(!visited[n]){
                visited[n]=true;
                count+=dfs(graph,n,visited);
            }
        }
        return count;
            
    }
    
    public long countPairs(int n, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(i, new ArrayList<Integer>());
        }
        for(int[] e:edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        long ans=0;
        ArrayList<Long> comps = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                comps.add(dfs(graph, i, visited));
            }
        }
        //System.out.print(comps);
        long sum =0;
        for(int i=0;i<comps.size();i++){
            
                sum+=comps.get(i);
            
        }// not reqd as sum is equal to number of vtces
        for(int i=0;i<comps.size();i++){
            long temp = sum-comps.get(i);
                ans = ans + comps.get(i)*temp;
            
        }
        return (ans/2);
    }
}