class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
       int[] days = new int[]{0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int asmonth = Integer.parseInt(arriveAlice.substring(0,2));
        int bsmonth = Integer.parseInt(arriveBob.substring(0,2));
        
        int asd = Integer.parseInt(arriveAlice.substring(3));
        int bsd = Integer.parseInt(arriveBob.substring(3));
        
        int almonth = Integer.parseInt(leaveAlice.substring(0,2));
        int blmonth = Integer.parseInt(leaveBob.substring(0,2));
        
        int ald = Integer.parseInt(leaveAlice.substring(3));
        int bld = Integer.parseInt(leaveBob.substring(3));
        if(asmonth>blmonth || bsmonth>almonth) return 0;
        int sm;
        int st;
        if(asmonth == bsmonth){
            sm = asmonth;
            st = Math.max(asd, bsd);
        } else if (asmonth > bsmonth){
            sm = asmonth;
            st = asd;
        }else{
            sm = bsmonth;
            st = bsd;
        }
        
        int lm;
        int lt;
        if(almonth == blmonth){
            lm = almonth;
            lt = Math.min(ald, bld);
        } else if (almonth > blmonth){
            lm = blmonth;
            lt = bld;
        }else{
            lm = almonth;
            lt = ald;
        }
        
        int ans = 0;
       // System.out.println(sm+"-"+ st+"="+ sm+"-"+lm);
        if(sm==lm){
            ans += lt-st+1;
            if(ans<0) ans=0;
        }else if(sm>lm){
            ans=0;
        }
        else{
            ans += days[sm] - st+1;
            for(int i = sm+1; i<lm;i++){
                ans+= days[i];
            }
            ans+=lt;
        }
        return ans;
    }
}