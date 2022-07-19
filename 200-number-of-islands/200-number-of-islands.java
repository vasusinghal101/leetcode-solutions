class Solution {
    public int numIslands(char[][] arr) {
        if(arr.length==0){
            return 0;
        }
     // boolean[][] visited = new boolean[arr.length][arr[0].length];
      int count = 0;
      for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < arr[0].length; j++) {
            if (arr[i][j] == '1') {
               gcc(arr, i, j);
               count++;
            }
         }
      }
      return count;
    }

   public void gcc(char[][] arr, int i, int j) {
      if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length ||  arr[i][j] == '0') {
            return;
      }

      arr[i][j] = '0';
      gcc(arr, i + 1, j);
      gcc(arr, i, j + 1);
      gcc(arr, i - 1, j);
      gcc(arr, i, j - 1);
   }
    
}