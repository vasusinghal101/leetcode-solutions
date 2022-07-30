class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] fmap = new int[26];
        
        for(int i = 0 ; i < words2.length;i++){
            int[] wmap = new int[26];
            for(char ch :  words2[i].toCharArray()){
                int idx = ch-'a';
                wmap[idx]++;
                
                if(wmap[idx]>fmap[idx])fmap[idx]=wmap[idx];
                
            }
        }
        
        List<String> ans = new ArrayList<>();
        
        for(String word : words1){
            if(isUniversal(word,fmap)){
                ans.add(word);
            }
        }
        
        return ans;
    }
    
    public boolean isUniversal(String word, int[] fmap){
        
        int[] wp = new int[26];
        for(char ch: word.toCharArray()){
            wp[ch-'a']++;
        }
        
        for(int i=0;i<26;i++){
            if(fmap[i]>wp[i]){
                return false;
            }
        }
        return true;
    }
}