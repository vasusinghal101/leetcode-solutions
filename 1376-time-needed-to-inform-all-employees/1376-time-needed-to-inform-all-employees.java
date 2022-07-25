class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
      
        ArrayList<Integer>[] g = new ArrayList[manager.length];
        for(int i = 0; i<manager.length ;i++) g[i] = new ArrayList<>();
       
        for(int i = 0; i<manager.length ;i++){
            if(manager[i]!=-1)
                g[manager[i]].add(i);
        }
        return Dfs(g,headID,0,informTime);
    }
    
    public int Dfs(ArrayList<Integer>[] g, int src, int time,int[] informTime){
        int max = time;
        for(int nbr: g[src]){
            max = Math.max(max, Dfs(g,nbr,time+informTime[src], informTime));
        }
        return max;
    }
}