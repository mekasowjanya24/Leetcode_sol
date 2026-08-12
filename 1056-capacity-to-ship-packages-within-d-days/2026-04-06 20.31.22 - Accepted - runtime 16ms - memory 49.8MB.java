class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=Arrays.stream(weights).max().getAsInt();
        int sum=0;
        for(int num:weights){
            sum=sum+num;
        }
        int high=sum;
        while(low<=high){
            int mid=low+(high-low)/2;
            int days_done=0;
            days_done=pack(weights,mid);
           if(days_done<=days)
           high=mid-1;
           else
           low=mid+1;
        }
        return low;
    }
        int pack(int [] weights,int capacity){
            int day=1,load=0;
            for(int i=0;i<weights.length;i++){
                if(load+weights[i]>capacity){
                    day++;
                    load=weights[i];
                }
                else
                load=load+weights[i];

            }
            return day;
        }
    }
