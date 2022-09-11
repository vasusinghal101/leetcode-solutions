class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        Queue<int[]> q = new LinkedList<>();
        for(int i =0; i<grid.length;i++){
            for(int j =0; j<grid[0].length;j++){
                if(grid[i][j]==2) q.add( new int[]{i,j});
            }
        }
        
        int ans=-1;
        
        while(q.size()>0){
            int s = q.size();
            
            while(s-- > 0){
                int[] cell = q.remove();
                for(int[] dir : dirs){
                    int nr = cell[0]+dir[0];
                    int nc = cell[1]+dir[1];
                    if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc]==1){
                      grid[nr][nc] = 2;
                      q.add(new int[]{nr,nc});
                    } 
                }
            }
            //System.out.println(q.size());
            ans++;
        }
        
        for(int i =0; i<grid.length;i++){
            for(int j =0; j<grid[0].length;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        
        return ans != -1 ? ans : 0;
    }
}