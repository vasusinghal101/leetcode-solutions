class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        for(int i = s.length()-1; i>=0;i--){
            char ch = s.charAt(i);
            Character m1 = i==0 ? '\0' : s.charAt(i-1);
            if(ch == 'I'){
                ans+=1;
            }else if(ch == 'V'){
                ans+=5;
                if(m1 == 'I'){
                    ans -= 1;
                    i--;
                }
            }else if(ch == 'X'){
                ans+=10;
                if(m1 == 'I'){
                    ans -= 1;
                    i--;
                }
            }else if(ch == 'L'){
                ans+=50;
                if(m1 == 'X'){
                    ans -= 10;
                    i--;
                }
            }else if(ch == 'C'){
                ans+=100;
                if(m1 == 'X'){
                    ans -= 10;
                    i--;
                }
            }else if(ch == 'D'){
                ans+=500;
                if(m1 == 'C'){
                    ans -= 100;
                    i--;
                }
            }else if(ch == 'M'){
                ans+=1000;
                if(m1 == 'C'){
                    ans -= 100;
                    i--;
                }
            }
        }
        
        return ans;
    }
}