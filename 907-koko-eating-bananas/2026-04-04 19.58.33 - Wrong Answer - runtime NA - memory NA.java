class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=Arrays.stream(piles).max().getAsInt();
        int ans=high;
        while(low<high){
            int mid=low+(high-low)/2;
           int total=function_koko(piles,mid);
           if(total<=h){
            ans=mid;
            high=mid-1;
           }
           else{
            low=mid+1;
           }

        }
return ans;
    }
   int function_koko(int []piles,int speed){
        int total_hours=0;
        for(int i=0;i<piles.length;i++){
           total_hours=total_hours+(piles[i]+speed-1)/speed;
        } 
        return total_hours;
    }
}
