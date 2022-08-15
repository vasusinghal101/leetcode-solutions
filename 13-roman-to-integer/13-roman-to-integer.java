class Solution {
    public int romanToInt(String s) {
        // Map to store romans numerals
        Map<Character, Integer> romanMap = new HashMap<>();
        // Fill the map
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        // Length of the given string
        int n = s.length();
        // Variable to store result
        int num = romanMap.get(s.charAt(n - 1));
        // Loop for each character from right to left
        for (int i = n - 2; i >= 0; i--) {
            // Check if the character at right of current character is
            // bigger or smaller
            if (romanMap.get(s.charAt(i)) >= romanMap.get(s.charAt(i + 1))) {
                num += romanMap.get(s.charAt(i));
            } else {
                num -= romanMap.get(s.charAt(i));
            }
        }
        return num;
//         int ans = 0;
//         for(int i = s.length()-1; i>=0;i--){
//             char ch = s.charAt(i);
//             Character m1 = i==0 ? '\0' : s.charAt(i-1);
//             if(ch == 'I'){
//                 ans+=1;
//             }else if(ch == 'V'){
//                 ans+=5;
//                 if(m1 == 'I'){
//                     ans -= 1;
//                     i--;
//                 }
//             }else if(ch == 'X'){
//                 ans+=10;
//                 if(m1 == 'I'){
//                     ans -= 1;
//                     i--;
//                 }
//             }else if(ch == 'L'){
//                 ans+=50;
//                 if(m1 == 'X'){
//                     ans -= 10;
//                     i--;
//                 }
//             }else if(ch == 'C'){
//                 ans+=100;
//                 if(m1 == 'X'){
//                     ans -= 10;
//                     i--;
//                 }
//             }else if(ch == 'D'){
//                 ans+=500;
//                 if(m1 == 'C'){
//                     ans -= 100;
//                     i--;
//                 }
//             }else if(ch == 'M'){
//                 ans+=1000;
//                 if(m1 == 'C'){
//                     ans -= 100;
//                     i--;
//                 }
//             }
//         }
        
//         return ans;
    }
}