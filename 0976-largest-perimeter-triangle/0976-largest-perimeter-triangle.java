class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
          int sum=0;
        for(int i=0;i<nums.length-2;i++){
            int a=nums[i];
            int b=nums[i+1];
            int c=nums[i+2];
          
          if(a+b>c){
            sum=a+b+c;
          }


        }
        return sum;
    }
}