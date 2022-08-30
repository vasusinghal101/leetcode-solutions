class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> gmap = new HashMap<>();
        
        for(int i=0; i<secret.length(); i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            
            if(s==g){
                bull++;
            }else{
                smap.put(s, smap.getOrDefault(s,0)+1);
                gmap.put(g, gmap.getOrDefault(g,0)+1);
            }
        }
        
        for(char ch : gmap.keySet()){
            cow+=Math.min(smap.getOrDefault(ch,0), gmap.getOrDefault(ch,0));
        }
        
        return bull+"A"+cow+"B";
    }
}