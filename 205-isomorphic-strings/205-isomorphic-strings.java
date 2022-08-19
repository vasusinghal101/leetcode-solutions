class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        
        HashMap<Character,Character> hm = new HashMap<>();
        HashSet<Character> hs = new HashSet<>();
        
        for(int i=0;i<s.length();i++){
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            // if(chs==cht){
            //     hm.put(chs,cht);
            //     continue;
            // }
            
            if(hm.containsKey(chs)){
                if(hm.get(chs)==cht){
                    continue;
                }else{
                    return false;
                }
            }else{
                if(hs.contains(cht)==false){
                    hs.add(cht);
                    hm.put(chs,cht);
                }else{
                    return false;
                }
            }
            
        }
        
        return true;
        
        // int m1[] = new int[256], n = s.length();
        // int m2[] = new int[256];
        // for (int i = 0; i < n; ++i) {
        //     if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
        //     m1[s.charAt(i)] = i + 1;
        //     m2[t.charAt(i)] = i + 1;
        // }
        // return true;
    }
}