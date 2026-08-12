class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[]={-1,-1};
        int l=0;
        int h=nums.length-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(nums[m]>=target){
                ans[0]=m;
                h=m-1;
            }
            else{
                l=m+1;
            }
        }
        if(ans[0]==-1 || nums[ans[0]]!=target)
        return new int[]{-1,-1};
        l=0;
        h=nums.length-1;
       while(l<=h){
        int m=l+(h-l)/2;
        if(nums[m]>target){
            ans[1]=m-1;
            h=m-1;
        }
        else
        l=m+1;
          
       }
       return ans;  
    }
}