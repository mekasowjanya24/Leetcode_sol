class Solution {
    public int arraySign(int[] nums) {
        int n=nums.length;
        int product=1;
        for(int i=0;i<n;i++){
            product=product*nums[i];
        }
        if(product==0)
        return 0;
        else if(product>0){
            return 1;
        }
        else
        return -1;
    }
}