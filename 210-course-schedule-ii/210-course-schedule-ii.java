class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge : prerequisites){
            graph[edge[1]].add(edge[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        int[] ans = new int[numCourses];
        int idx = 0;
        
        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int nbr : graph[i]) indegree[nbr]++;
        }
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0) q.add(i);
        }
        
        while(q.size()>0){
            int nc = q.remove();
            ans[idx] = nc;
            idx++;
            
            for(int nbr : graph[nc]){
                indegree[nbr]--;
                if(indegree[nbr] ==0) q.add(nbr);
            }
        }
        
        return idx==numCourses ? ans : new int[0];
    }
}