class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
       int n=nums.length;
       int candidate1=nums[n-1]*nums[n-2]*nums[n-3];
       int candidate=nums[0]*nums[1]*nums[n-1];
       return Math.max(candidate1,candidate);
        
    }
}