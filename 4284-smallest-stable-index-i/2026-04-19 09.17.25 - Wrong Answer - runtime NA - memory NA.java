class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            int max=Integer.MIN_VALUE;
            for(int j=0;j<i;j++){
                 max=Math.max(max,nums[i]);
            }
            int min=Integer.MIN_VALUE;
            for(int j=i;j<n;j++){
                min=Math.min(min,nums[i]);
            }
            int c=max-min;
            if(c==k)
                return i;
        }
        return -1;
    }
}