class Solution {
    
    public class Pair{
        int sd;
        int idx;
        
        public Pair(int sd, int idx){
            this.sd=sd;
            this.idx=idx;
        }
        
    }
    public int maximumSum(int[] nums) {
        if(nums.length == 1){
            return -1;
        }
        
        Pair[] h = new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            int s = sumOfDigit(nums[i]);
            h[i] = new Pair(s,nums[i]);
        }
        
        Arrays.sort(h, (a,b) -> a.sd!=b.sd ? a.sd-b.sd : a.idx-b.idx);
        
        int max =-1;
        
        for(int i=1;i<h.length;i++){
            Pair f = h[i-1];
            Pair s = h[i];
            
            if(f.sd==s.sd){
                int temp = f.idx+s.idx;
                max = Math.max(max, temp);
            }
        }
        return max;
    }
    
    public int sumOfDigit(int n){
        int s=0;
        
        while(n>0){
            s+= n%10;
            n = n/10;
        }
        
        return s;
    }
}