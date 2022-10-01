class Solution {
    public boolean equalFrequency(String word) {
        int[] fmap = new int[26];
        
        for(char ch: word.toCharArray()){
            fmap[ch-'a']++;
        }
        
        Arrays.sort(fmap);
        if(fmap[24]==0) return true;
        int freq=0;
        boolean ff=false;
        for(int i=0;i<26;i++){
            if(fmap[i]==0) continue;

            if(!ff){
                ff=true;
                freq=fmap[i];
                if(freq==1){
                    if(fmap[25]==1 || (i<25 && fmap[i+1] == fmap[25]) || (fmap[24]==1&&fmap[25]==2)) {
                        return true;
                    } else{
                        return false;
                    }
                }
            }else{
                if(fmap[i]==freq) continue;
                else{
                    if(fmap[i] == freq+1 && i==25) return true;
                    else return false;
                }
            }
            
        }
        return false;
    
    }
}