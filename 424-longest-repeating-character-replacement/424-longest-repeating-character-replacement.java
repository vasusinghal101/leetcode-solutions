class Solution {
    public int characterReplacement(String s, int k) {
        //keep max range possible with zero k;
        //max freq characer - total length of window
        // if after adding new char in window k does not support brint it in rnge by removing characters from front
        if(k>=s.length()-1){
            return s.length();
        }
        int[] fmap = new int[26];
        int si = 0;
        int ei = 0;
        int ans = 0;
        int maxFc = 0;
        while(ei<s.length()){
            int idx = s.charAt(ei) - 'A';
            fmap[idx]++;
            if(fmap[idx]>fmap[maxFc]) maxFc = idx;
            
            int reqdk = ei-si-fmap[maxFc]+1;
            
            if(reqdk>k){
                //get si to valid place
                fmap[s.charAt(si) - 'A']--;
                si++;
            }
            
            ans = Math.max(ans, ei-si+1);
            ei++;
        }
        
        return ans;
    }
}