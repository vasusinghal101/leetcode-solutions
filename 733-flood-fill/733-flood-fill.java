class Solution {
    public void DFS(int[][] image,int oc, int sr, int sc, int color) {
        if(image[sr][sc]!=oc){
            return;
        }
        if(oc==color){
            return;
        }
        image[sr][sc]=color;
        if(sr+1<image.length) DFS(image, oc, sr+1, sc, color);
        if(sc+1<image[0].length) DFS(image, oc, sr, sc+1, color);
        if(sr-1>=0) DFS(image, oc, sr-1, sc, color);
        if(sc-1>=0) DFS(image, oc, sr, sc-1, color);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        DFS(image, image[sr][sc] , sr, sc, color);
        return image;
    }
}