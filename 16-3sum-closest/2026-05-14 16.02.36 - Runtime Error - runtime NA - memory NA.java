class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1])
            continue;
            int j=i+1;
            int k=n-1;
            int sum=nums[i]+nums[j]+nums[k];
            if(sum==target || sum==target-1 ||sum==target+1)
            return sum;
        }
return 0;
    }
}