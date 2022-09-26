class Solution {
    class Dsu{
        int[] p;
        
        Dsu(){
            p = new int[26];
            for(int i=0;i<26;i++) p[i]=i;
        }
        
        public void union(char a, char b){
            int pa = find(a);
            int pb = find(b);
            
            if(pa==pb) return;
            p[pb]=pa;
        }
        
        public int find(char ch){
            int idx = ch - 'a';
            if(p[idx] == idx) return idx;
            p[idx] = find((char)('a'+p[idx]));
            return p[idx];
        }
        
        public boolean possible(char ch1, char ch2){
            int pch1 = find(ch1);
            int pch2 = find(ch2);
            //System.out.println("possible " + pch1 +" "+ pch2);
            if(pch1==pch2) return false;
            else return true;
        }
    }
    public boolean equationsPossible(String[] equations) {
        Dsu d = new Dsu();
        for(String str:equations){
            char ch1 = str.charAt(0);
            char ch2 = str.charAt(3);
            char e = str.charAt(1);
            if(e == '='){
                d.union(ch1,ch2);
            }
        }
        
        for(String str:equations){
            char ch1 = str.charAt(0);
            char ch2 = str.charAt(3);
            char e = str.charAt(1);
            if(e == '!'){
                boolean possible = d.possible(ch1,ch2);
                //System.out.println(possible+ " " + ch1 +" "+ ch2);
                //System.out.println(Arrays.toString(d.p));
                if(!possible) return false;
            }
        }
       // System.out.println(Arrays.toString(d.p));
        return true;
    }
}