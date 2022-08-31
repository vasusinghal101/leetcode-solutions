class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length()-1;
        int j = t.length()-1;
        int count;       
        while(i>=0 || j>=0){
            count = 0;
            while(i>=0){
                if(s.charAt(i) == '#'){
                    i--;
                    count++;
                }else if(count>0){
                    count--;
                    i--;
                }else{
                    break;
                }
            }
            
            count = 0;
            while(j>=0){
                if(t.charAt(j) == '#'){
                    j--;
                    count++;
                }else if(count>0){
                    count--;
                    j--;
                }else{
                    break;
                }
            }
            
            
            if(i>=0 && j>=0 && s.charAt(i)!=t.charAt(j)){
                return false;
            }
            if(i<0 != j<0){
                return false;
            }
            i--;j--;
        }
        
        return true;
    }
}