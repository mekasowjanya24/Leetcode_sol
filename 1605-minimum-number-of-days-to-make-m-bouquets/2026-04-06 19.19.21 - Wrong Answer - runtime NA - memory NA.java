class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low=Arrays.stream(bloomDay).min().getAsInt();
        int high=Arrays.stream(bloomDay).max().getAsInt();
        if(bloomDay.length<(long)(m*k))
        return -1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(poss(bloomDay,mid,m,k)==true)
            high=mid-1;
            else
            low=mid+1;
        }
        return low;
    }
  boolean poss(int []bloomDay,int day,int m,int k){
        int count=0;
        int boq=0;
        
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=day)
            count=count+1;
            else{
            boq=boq+(count/k);
            count=0;
            }
            
        }
        boq=boq+(count/k);
        if(boq>=m)
        return true;
        else
        return false;

        
    }
}