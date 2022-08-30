class Solution {
//    public String longestCommonPrefix(String[] strs) {
//         StringBuilder sb = new StringBuilder();
//         int j = 0;
//         char ch = '\0';
//         boolean flag=true;
//         while(flag){
//            if(j >= strs[0].length()){
//                flag = false;     
//                break;
//            }else{
//                ch = strs[0].charAt(j);
//            }
//            for(int i=1; i<strs.length;i++){
//                 if(j >= strs[i].length() || ch != strs[i].charAt(j)){
//                     flag =false;
//                     break;
//                 }
//             }
//             if(flag) sb.append(ch);
//             j++;
//         }
        
//         return sb.toString();
        
//     }
    public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    for (int i = 0; i < strs[0].length() ; i++){
        char c = strs[0].charAt(i);
        for (int j = 1; j < strs.length; j ++) {
            if (i == strs[j].length() || strs[j].charAt(i) != c)
                return strs[0].substring(0, i);             
        }
    }
    return strs[0];
}
}
