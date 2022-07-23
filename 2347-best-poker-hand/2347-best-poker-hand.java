class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        
        char s = suits[0];
        boolean f=true;
        for(char ch : suits){
            if(ch!=s){
                f = false;
                break;
            }
        }
        
        int[] rank = new int[14];
        boolean three = false;
        boolean two = false;
        for(int r :ranks){
            rank[r]++;
            if(rank[r]==3){
                three =true;
                break;
            }else if(rank[r]==2){
                two=true;
            }
        }
        
        if(f){
            return "Flush";
        }else if(three){
            return "Three of a Kind";
        }else if(two){
            return "Pair";
        }else{
            return "High Card";
        }
    }
}