class Solution {
    public String reverseWords(String s) {
       char[] arr = s.toCharArray();
        int i=0;
        int j=0;
        while(j<s.length()){
            char ch = s.charAt(j);
            if(ch == ' '){
                reverse(arr, i , j-1);
                while(j<s.length() && s.charAt(j) == ' '){
                    j++;
                }
                i=j;
                continue;
            }
            j++;
        }
        
        reverse(arr, i, j-1);
        
        return String.copyValueOf(arr);
    }
    
    public void reverse(char[] chArray, int startIndex, int endIndex){
        while(startIndex<endIndex){       
            char temp = chArray[startIndex];
            chArray[startIndex] = chArray[endIndex];
            chArray[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}