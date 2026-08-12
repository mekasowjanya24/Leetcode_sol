class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        Arrays.sort(nums);
        List<Integer>ds=new ArrayList<>();
        solve(0,nums,ds,ans);
        return ans;
    }

        private void solve(int start,int [] nums,List<Integer>ds,List<List<Integer>>ans){
       
        ans.add(new ArrayList<>(ds));
        for(int i=start;i<nums.length;i++){
            if(i!=start && nums[i]==nums[i-1])
            continue;
            ds.add(nums[i]);
            solve(i+1,nums,ds,ans);
            ds.remove(ds.size()-1);
        }
        }
}
        
    
