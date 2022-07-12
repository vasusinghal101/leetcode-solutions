class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int m : matchsticks)
            sum+=m;
        
        if(sum%4!=0)
            return false;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int side = sum/4;
        return helper(matchsticks,side,0,0,0,0,0);
    }
    
    public boolean helper(int[] m,int side, int i, int s1 , int s2,int s3,int s4){
        if(s1 > side || s2 > side || s3>side || s4>side){
            return false;
        }
        if(i>=m.length){
            if(s1==s2 && s3==s4 && s1==s4){
                return true;
            }else{
                return false;
            }
        }
        
        boolean b1 = helper(m,side,i+1,s1+m[i],s2,s3,s4);
        boolean b2 =helper(m,side,i+1,s1,s2+m[i],s3,s4);
        boolean b3 = helper(m,side,i+1,s1,s2,s3+m[i],s4);
        boolean b4 = helper(m,side,i+1,s1,s2,s3,s4+m[i]);
        
        if(b1 || b2 || b3 || b4){
            return true;
        }else{
            return false;
        }
    }
    
     private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }
}