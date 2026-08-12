class Solution {
    public int maxDigitRange(int[] nums) {
        int n=nums.length;
        int highest_range=-1;
        int sum=0;
        for(int i=0;i<n;i++){
            int a=nums[i];
            int max=0,min=9;
            if(a==0){
                min=0;
                max=0;
            }
            else{
                while(a>0){
                    int rem=a%10;
                    max=Math.max(max,rem);
                    min=Math.min(min,rem);
                    a=a/10;
                }
            }
            int range=max-min;
            if(range>highest_range){
                highest_range=range;
                sum=a;
            }
            else if(range==highest_range){
                sum=sum+a;
            }
    
            
        }
        return sum;
        
    }
}