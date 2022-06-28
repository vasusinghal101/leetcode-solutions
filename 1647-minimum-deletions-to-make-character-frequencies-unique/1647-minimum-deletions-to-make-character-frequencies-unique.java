class Solution {
    public int minDeletions(String s) {
        int[] fmap = new int[26];
        
        for(char ch : s.toCharArray()){
            fmap[ch-'a']++;
        }
        
        Arrays.sort(fmap);
        
        int ans = 0;
        int max = fmap[25]-1;
        for(int i=24;i>=0 &&fmap[i]>0;i--){
            if(fmap[i]<max){
                max=fmap[i]-1;
            }else{
                ans+=fmap[i]-max;
                max=Math.max(max-1,0);
            }
        }
        
        return ans;
    }
}