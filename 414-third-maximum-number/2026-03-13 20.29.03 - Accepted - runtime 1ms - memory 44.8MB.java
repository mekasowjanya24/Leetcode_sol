class Solution {
    public int thirdMax(int[] nums) {
            long max_1=Long.MIN_VALUE;
            long max_2=Long.MIN_VALUE;
            long max_3=Long.MIN_VALUE;
            
            for(int i=0;i<nums.length;i++){
                if(nums[i]==max_1||nums[i]==max_2||nums[i]==max_3)
                continue;
                if(nums[i]>max_1){
                    max_3=max_2;
                    max_2=max_1;
                    max_1=nums[i];  
                }
                else if(nums[i]>max_2){
                    max_3=max_2;
                    max_2=nums[i];
                }
                else if(nums[i]>max_3){
                    max_3=nums[i];
                }
            }
            
          if(max_3==Long.MIN_VALUE)
          return(int)max_1;
          return (int) max_3;
    
    }
}