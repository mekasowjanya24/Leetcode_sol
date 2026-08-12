class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int pro=1;
        for(int i=nums.length-1;i>nums.length-4;i--){
            pro=pro*nums[i];

        }
        return pro;
        
    }
}