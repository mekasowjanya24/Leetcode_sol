class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n=nums.length;
        int even[]=new int[n/2];
        int odd[]=new int[n/2];
        int j=0;
        int k=0;
        for(int num:nums){
            if(num % 2==0){
            even[j]=num;
            j++;
            }
            else{
            odd[k]=num;
            k++;
            }
        }
        for(int i=0;i<n/2;i++){
            nums[2*i]=even[i];
            nums[2*i+1]=odd[i];
        }
        return nums;
    }
}