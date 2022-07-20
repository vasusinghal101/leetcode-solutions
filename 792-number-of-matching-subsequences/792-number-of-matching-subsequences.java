class Pair{
    int sti;
    int chi;
    
    public Pair(int sti, int chi){
        this.sti=sti;
        this.chi=chi;
    }
}
class Solution {
    
    public int numMatchingSubseq(String S, String[] words) {
        
        ArrayList<Pair>[] heads = new ArrayList[26];
        int count =0;
        for (int i = 0; i < 26; ++i)
            heads[i] = new ArrayList<Pair>();
        int i=0;
        for(String w : words){
            heads[w.charAt(0)-'a'].add(new Pair(i,0));
            i++;
        }
        
        for(char ch : S.toCharArray()){
            ArrayList<Pair> t = heads[ch-'a'];
            heads[ch-'a'] = new ArrayList<Pair>();
            for(Pair p : t){
                String w = words[p.sti];
                if(p.chi == w.length()-1){
                    count++;
                }else{
                    heads[w.charAt(p.chi+1)-'a'].add(new Pair(p.sti,p.chi+1));
                }
            }
        }
//         int count=0;
//         for(String str : words){
//             int j = 0;
//             for(int i =0;i<S.length() && j<str.length();i++){
//                 char chs = S.charAt(i);
//                 char chstr = str.charAt(j);
//                 if(chs == chstr) j++;
//             }
//             if(j==str.length()){
//                 count++;
//             }
//         }
        
         return count;
        
    }
}