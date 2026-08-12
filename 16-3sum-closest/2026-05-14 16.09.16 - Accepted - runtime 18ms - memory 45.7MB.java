class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        int closest=nums[0]+nums[1]+nums[2];
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1])
            continue;
            int j=i+1;
            int k=n-1;
            while(j<k){
            int sum=nums[i]+nums[j]+nums[k];
            if(Math.abs(sum-target)<Math.abs(closest-target)){
                closest=sum;
            }
            if(sum==target)
            return sum;
            else if(sum<target)
            j++;
            else
            k--;
            }
        }
return closest;
    }
}