class Solution {
    public int numEnclaves(int[][] arr) {
         if(arr.length==0){
            return 0;
        }
     // boolean[][] visited = new boolean[arr.length][arr[0].length];
      int count = 0;
         for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
              if (arr[i][j] == 1) {
                 int c = gcc(arr,i,j);
                  if(c!=-1){
                      count+=c;
                  }
              }
            }
          }
      return count;
        
    }
    
    public int gcc(int[][] arr, int i, int j) {
      if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) {
            return -1;
      }
        if(arr[i][j] == 0){
            return 0;
        }
      arr[i][j] = 0;
      int ans = 1;
      int ans1 = gcc(arr, i + 1, j);
      int ans2 = gcc(arr, i, j + 1);
      int ans3 = gcc(arr, i - 1, j);
      int ans4 = gcc(arr, i, j - 1);
        
      if(ans1 == -1 || ans2 == -1 || ans3 ==-1 || ans4 == -1){
          return -1;
      }else{
         return ans+ans1+ans2+ans3+ans4;  
      }
   }
//     public int numEnclaves(int[][] arr) {
//          if(arr.length==0){
//             return 0;
//         }
//      // boolean[][] visited = new boolean[arr.length][arr[0].length];
//       int count = 0;
//       for (int i = 0; i < arr.length; i++) {
//          if (arr[i][0] == 1) {
//                gcc(arr, i, 0);
//             }
//            if (arr[i][arr[0].length-1] == 1) {
//                gcc(arr, i, arr[0].length-1);
//             }
         
//       }

//       for (int j = 0; j < arr[0].length; j++) {
//             if (arr[0][j] == 1) {
//                gcc(arr, 0, j);
//             }
//           if (arr[arr.length-1][j] == 1) {
//                gcc(arr, arr.length-1, j);
//             }
//         }
        
        
//          for (int i = 0; i < arr.length; i++) {
//             for (int j = 0; j < arr[0].length; j++) {
//               if (arr[i][j] == 1) {
//                  count++;
//               }
//             }
//           }
//       return count;
        
//     }
    
//     public void gcc(int[][] arr, int i, int j) {
//       if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || 
//           arr[i][j] == 0) {
//             return;
//       }

//       arr[i][j] = 0;
        
//       gcc(arr, i + 1, j);
//       gcc(arr, i, j + 1);
//       gcc(arr, i - 1, j);
//       gcc(arr, i, j - 1);
//    }
}