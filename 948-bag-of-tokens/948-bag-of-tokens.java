class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i = 0;
        int l = 0;
        int r = tokens.length-1;
        int max = 0;
        int score = 0;
        while(l<=r && i<tokens.length){
            if(tokens[l]<=power){
                score++;
                power-=tokens[l];
                l++;
            }else{
                if(score>0){
                    score--;
                    power+=tokens[r];
                    r--;
                }
            }
            max = Math.max(score,max);
            i++;
        }
        
        return max;
    }
}