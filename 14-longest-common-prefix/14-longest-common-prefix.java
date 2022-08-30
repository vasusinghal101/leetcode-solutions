class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int j = 0;
        char ch = '\0';
        boolean flag=true;
        while(flag){
           if(j >= strs[0].length()){
               flag = false;     
               break;
           }else{
               ch = strs[0].charAt(j);
           }
           for(int i=1; i<strs.length;i++){
                if(j >= strs[i].length() || ch != strs[i].charAt(j)){
                    flag =false;
                    break;
                }
            }
            if(flag) sb.append(ch);
            j++;
        }
        
        return sb.toString();
        
    }
}