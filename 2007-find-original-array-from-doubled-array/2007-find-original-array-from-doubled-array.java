class Solution {
    public int[] findOriginalArray(int[] changed) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int n: changed) hm.put(n, hm.getOrDefault(n, 0)+1);
        
        Arrays.sort(changed);
        
        int count=0;
        int[] ans = new int[changed.length/2];
        for(int i=0; i<changed.length && count<changed.length+1/2;i++){
            int n = changed[i];
            int hf = hm.get(n);
            if(hf>0){
                hm.put(n, hm.get(n)-1);
                int df = hm.getOrDefault(2*n, 0);
                if(df>0){
                    ans[count] = n;
                    count++;
                    
                    hm.put(2*n, hm.get(2*n)-1);
                }else{
                    return new int[0];    
                }
            }
        }
        return ans;
    }
}