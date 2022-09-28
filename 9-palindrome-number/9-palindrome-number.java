class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        
        int c = x;
        int rev = 0;
        while(c>0){
            int d = c%10;
            c=c/10;
            rev=rev*10+d;
        }
        
        return x==rev;
    }
}