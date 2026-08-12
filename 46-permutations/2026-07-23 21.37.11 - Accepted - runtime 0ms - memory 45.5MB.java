class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(nums,0,result);
        return result;
        }
       void backtrack(int [] nums,int start,List<List<Integer>> result){
        if(start==nums.length){
            List<Integer>perm=new ArrayList<>();
            for(int n:nums){
            perm.add(n);
            }
            result.add(perm);
            return;
        }
             for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);       
            backtrack(nums, start + 1, result); 
            swap(nums, start, i);    
        }
    }

    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
     
