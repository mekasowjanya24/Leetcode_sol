class Solution {
    public List<Integer> findValidElements(int[] nums) {
        List <Integer> list=new ArrayList<>();
        int n=nums.length;
       int[] prefix=new int[n];
        int [] suffix=new int[n];
        prefix[0]=Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            prefix[i]=Math.max(prefix[i-1],nums[i-1]);
        }
        suffix[n-1]=Integer.MIN_VALUE;
        for(int i=n-2;i>=0;i--){
            suffix[i]=Math.max(suffix[i+1],nums[i+1]);
        }
        for(int i=0;i<n;i++){
            if(nums[i]>prefix[i] || nums[i]>suffix[i])
                list.add(nums[i]);
        }
       
       
        return list;
    }
}