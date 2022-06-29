class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int[]>(){
            
            public int compare(int[] a, int[] b){
                if(a[0]!=b[0]){
                    return b[0]-a[0];
                }else{
                    return a[1]-b[1];
                }
                
            }
        });
        
        ArrayList<int[]> ans = new ArrayList<>();
        
        for(int[] arr:people){
            ans.add(arr[1],arr);
        }
        
        return ans.toArray(new int[people.length][]);
    }
}