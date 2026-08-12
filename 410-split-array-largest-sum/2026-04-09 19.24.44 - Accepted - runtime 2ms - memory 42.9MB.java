class Solution {
    public int splitArray(int[] nums, int k) {
        if(k>nums.length)return -1;
        int low=Arrays.stream(nums).max().getAsInt();
        int sum=0;
        for(int num:nums){
            sum=sum+num;
        }
        int high=sum;
        while(low<=high){
            int mid=low+(high-low)/2;
            int k_value=fun(nums,mid);
            if(k_value>k){
                low=mid+1;
            }
            else
            high=mid-1;
        }
        return low;
    }
    int fun(int nums[],int mid){
        int k_initial=1;
        int sub_sum=0;
        for(int i=0;i<nums.length;i++){
            if(sub_sum+nums[i]<=mid)
            sub_sum=sub_sum+nums[i];
            else{
                k_initial++;
                sub_sum=nums[i];
            }
        }
        return k_initial;
    }
}