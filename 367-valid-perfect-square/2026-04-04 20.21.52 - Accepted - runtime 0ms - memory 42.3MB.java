class Solution {
    public boolean isPerfectSquare(int num) {
        int low=1;
        int high=num;
        while(low<=high){
            int mid=low+(high-low)/2;
            long x=(long)mid*mid;
            if(x==num)
            return true;
            else if(x>num)
                high=mid-1;
                else
                low=mid+1;
            
        }
        return false;
    }
}