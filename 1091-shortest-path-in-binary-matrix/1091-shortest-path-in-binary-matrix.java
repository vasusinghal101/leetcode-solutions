class Solution {
    //Finding the shortest path between two nodes in a graph is almost always done using BFS, and all programmers should know this. BFS is one of the fundamental algorithms that you are expected to be confident coding before a tech interview. So, if you're finding this question challenging, then you're doing the right thing by working on it now.

    private static int[][] dirs = new int[][]{{1,1},{1,-1},{-1,-1},{-1,1},{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0){
            return -1;
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0});
        grid[0][0]=1;
        while(q.size()>0){
            int[] cell = q.remove();
            int row = cell[0];
            int col = cell[1];
            int distance = grid[row][col];
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return distance;
            }
            
            for (int[] neighbour : getNeighbours(row, col, grid)) {
                int neighbourRow = neighbour[0];
                int neighbourCol = neighbour[1];
                q.add(new int[]{neighbourRow, neighbourCol});
                grid[neighbourRow][neighbourCol] = distance + 1;
            }
            
        }
        
        return -1;
    }
    
     private List<int[]> getNeighbours(int row, int col, int[][] grid) { 
        List<int[]> neighbours = new ArrayList<>();
        for (int i = 0; i < dirs.length; i++) {
            int newRow = row + dirs[i][0];
            int newCol =col + dirs[i][1];
            if (newRow < 0 || newCol < 0 || newRow >= grid.length 
                    || newCol >= grid[0].length
                    || grid[newRow][newCol] != 0) {
                continue;    
            }
            neighbours.add(new int[]{newRow, newCol});
        }
        return neighbours;
     }
}