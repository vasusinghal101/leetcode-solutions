class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i<s.length()){
            char ch = s.charAt(i);
            if(ch!=']'){
                st.push(ch);
            }else{
                String str="";
                while(st.peek()!='['){
                    str+=st.pop();
                }
                st.pop();
                String digit="";
                while(st.size()>0 && st.peek() >='0' && st.peek()<='9'){
                    digit += st.pop();
                }
                
                str = reverse(str);
                int d = Integer.parseInt(reverse(digit));
                for(int k = 0; k<d;k++){
                    for(char c: str.toCharArray()){
                        st.push(c);
                    }
                }
            }
            i++;
        }
        
        while(st.size()>0){
            sb.append(st.pop());
        }
        sb = sb.reverse();
        return sb.toString();
        
    }
    
    public String reverse(String s) {
        char[] arr = s.toCharArray();
        int i =0;
        int j = s.length()-1;
        while(i<j){
            char t = arr[i];
            arr[i]=arr[j];
            arr[j]=t;
            i++;
            j--;
        }
        
        return String.valueOf(arr);
    }
}