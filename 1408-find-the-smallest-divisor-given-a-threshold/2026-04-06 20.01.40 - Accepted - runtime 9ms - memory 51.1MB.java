class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        if(nums.length>threshold)
        return -1;
        int  low=1;
        int high=Arrays.stream(nums).max().getAsInt();
        while(low<=high){
            int mid=low+(high-low)/2;
            if(sumdiv(nums,mid)<=threshold)
            high=mid-1;
            else
            low=mid+1;
        }
        return low;
    }
    int sumdiv(int []nums,int divisor){
         
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+(nums[i]+divisor-1)/divisor;
        }
        return sum;
    }
}