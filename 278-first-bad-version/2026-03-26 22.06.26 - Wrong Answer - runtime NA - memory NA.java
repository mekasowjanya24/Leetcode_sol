/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l=0;
        int h=n-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(isBadVersion(m))
             return m;
             else{
                l=m+1;
             }
        }
        return 1;
    }
}