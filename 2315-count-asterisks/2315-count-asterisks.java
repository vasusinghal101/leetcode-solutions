class Solution {
    public int countAsterisks(String s) {
        int ans  = 0;
        int count =0;
        boolean flag = false;
        for(char ch: s.toCharArray()){
            if(ch == '|'){
                if(flag){
                    count = 0;
                    flag=false;
                }else{
                    flag=true;
                    ans+=count;
                    count=0;
                }
            }
            if(ch == '*'){
                count++;
            }
            
        }
        
        ans+=count;
        
        return ans;
    }
}