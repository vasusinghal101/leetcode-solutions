class Solution {
    public int longestPalindrome(String[] words) {
        //Can  be done in single pass keep count of symmetric 
        //update it accordingly in last check if>0
        HashMap<String, Integer> hm = new HashMap();
        int sym = 0;
        int ans = 0;
        for(String word: words){
            char ch1 = word.charAt(0);
            char ch2 = word.charAt(1);
            String reverse = ch2+""+ch1; 
            if(hm.getOrDefault(reverse, 0)>0){
                ans+=4;
                hm.put(reverse, hm.get(reverse)-1);
                sym += ch1==ch2 ? -1 : 0;
            }else{
                hm.put(word, hm.getOrDefault(word,0)+1);
                 sym += ch1==ch2 ? 1 : 0;
            } 
        }
        
        // for(String word: hm.keySet()){
        //     if(word.charAt(0) == word.charAt(1) && hm.get(word)>0){
        //       ans+=2;
        //       break;
        //     }
        // }
        
        return ans + (sym>0 ? 2 : 0);
    }
}