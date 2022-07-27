class Solution {
    int[][] dirs = {{1,0}, {-1,0}, {0, 1}, {0,-1}};
    public void dfs(int[][] heights, boolean[][] vis, int r, int c){
        if(vis[r][c]){
            return;
        }
        vis[r][c] = true;
        
        for(int i=0;i<dirs.length;i++){
            int nr = r + dirs[i][0];
            int nc = c + dirs[i][1];
            
            if(nr<0 || nc <0 || nr>=vis.length || nc>=vis[0].length){
                continue;
            }
            
            if(heights[nr][nc] >= heights[r][c]){
                dfs(heights,vis,nr,nc);
            }
        }
        
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int n = heights.length;
        int m = heights[0].length;
        
        boolean[][] p = new boolean[n][m];
        boolean[][] a = new boolean[n][m];
        for(int i=0;i<n;i++){
            dfs(heights, p, i, 0);
            dfs(heights, a, i, m-1);
        }
        for(int i=0;i<m;i++){
            dfs(heights, p, 0, i);
            dfs(heights, a, n-1, i);
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(p[i][j] && a[i][j]){
                    List<Integer> point = new ArrayList<>();
                    point.add(i);
                    point.add(j);
                    ans.add(point);
                }
            }
        }
        
        return ans;
        
        
    }
}