class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] fmap = new int[26];
        
        int max=0;
        int maxCount=0;
        
        for(char ch : tasks){
            int idx = ch-'A';
            fmap[idx]++;
            
            if(max<fmap[idx]){
                max = fmap[idx];
                maxCount=1;
            }else if(max == fmap[idx]){
                maxCount++;
            }
        }
        
        int parts = max-1;
        int space = n - maxCount + 1;
        
        int empty = parts*space;
        int idles = Math.max(0, empty - (tasks.length - (max*maxCount)));
        
        return tasks.length+idles;
    }
}