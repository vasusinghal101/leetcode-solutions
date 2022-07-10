class Solution {
    public boolean canChange(String start, String target) {
        int rb=0,rel=0;
        for(int i=0;i<start.length();i++){
            char ch = start.charAt(i);
            char t =target.charAt(i);
            if( t == 'L'){
                rel++;
            }
            if( ch == 'R'){
                rb++;
            }
            
            if( t == 'R'){
                if(rel>0){
                    return false;
                }
                if(rb>0){
                    rb--;
                }else{
                    return false;
                }
            }
            
            if( ch == 'L'){
                if(rb>0){
                    return false;
                }
                if(rel>0){
                    rel--;
                }else{
                    return false;
                }  
            }
            
        }
        
        if(rb==0 && rel==0){
            return true;
        }else{
            return false;
        }
    }
}