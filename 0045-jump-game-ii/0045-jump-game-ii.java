class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int jumps=0;
        int l=0,r=0;
        while(r<n-1){
            int farthest=0;
            for(int index=l;index<=r;index++){
                farthest=Math.max(index+nums[index],farthest);
            }
            l=r+1;
            r=farthest;
            jumps++;
        }
        return jumps;
        
    }
}