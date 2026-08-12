class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        solve(candidates,target,0,new ArrayList<>(),ans);
        return ans;
    }
        private void solve(int[] candidates,int target,int ind,List<Integer>ds,List<List<Integer>>ans)
   {
    if(ind==candidates.length){
        if(target==0)
        ans.add(new ArrayList<>(ds));
        return;
    }
 if(candidates[ind]<=target){
        ds.add(candidates[ind]);
        solve(candidates,target-candidates[ind],ind,ds,ans);
        ds.remove(ds.size()-1);
    }
        solve(candidates,target,ind+1,ds,ans);

    }
}