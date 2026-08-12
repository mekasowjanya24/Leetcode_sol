class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int count1=0,count2=0,count0=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0)
            count0++;
            else if(nums[i]==1)
            count1++;
            else
            count2++;
        }
      int i=0;
            while(count0!=0){
                nums[i]=0;
                i++;
                count0--;
            }
            while(count1!=0){
                nums[i]=1;
                i++;
                count1--;
            }
            while(count2!=0){
                nums[i]=2;
                i++;
                count2--;
            }
        
    }
}