class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        
        for(int ast : asteroids){
            if(ast>0){
                st.push(ast);
            }else if (ast==0) continue;
            else{
                while(!st.isEmpty() && st.peek()>0 && st.peek() < Math.abs(ast)){ 
                    st.pop();
                }
                
                if(st.isEmpty() || st.peek()<0){
                    st.push(ast);
                } else if( st.peek() == Math.abs(ast)){ 
                    st.pop();
                }
            }
        }
        
        int[] ans = new int[st.size()];
        
        for(int i= st.size()-1; i >=0;i--){
            ans[i] = st.pop();
        }
        
        return ans;
    }
}