class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sizep = p.length();
        int sizes = s.length();
        if(sizes<sizep){
            return new ArrayList<Integer>();
        }
        int[] fmap = new int[26];
        int[] smap = new int[26];
        for( int i=0;i<sizep;i++){
            int ch = (int)p.charAt(i);
            fmap[ch-97]++;
            ch = (int)s.charAt(i);
            smap[ch-97]++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
            if(Arrays.equals(fmap, smap)){
                ans.add(0);
            }
        
        
        for(int i=sizep;i<sizes;i++){
            int remCh = (int)s.charAt(i-sizep);
            int addCh = (int)s.charAt(i);
            smap[remCh-97]--;
            smap[addCh-97]++;
            if(Arrays.equals(fmap, smap)){
                ans.add(i-sizep+1);
            }
        }
        
        return ans;
    }
}