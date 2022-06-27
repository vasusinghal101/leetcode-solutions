class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int j=0,k=0;
            while(j<t.length()&&k<s.length()){
                if(s.charAt(k)==t.charAt(j)){
                    j++;
                    k++;
                }else{
                    j++;
                }
                
            }
            if(k==s.length()){
                return true;
            }
        
        return false;
        
    }
}