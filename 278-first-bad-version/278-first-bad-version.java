/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1;
        int h = n;
        
        while(l<h){
            int m = l+ (h-l)/2;
            boolean isbad = isBadVersion(m);
            if(isbad){
                h=m;
            }else{
                l=m+1;
            }
        }
        
        return h;
    }
}