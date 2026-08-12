class Solution {
    public List<Integer> findValidElements(int[] nums) {
        List <Integer> list=new ArrayList<>();
        int n=nums.length;
        int left=0;
        int right=n-1;
        for(int i=1;i<n-1;i++){
            while(left<=i){
                if(nums[i]>nums[left])
                    left++;
                else
                    break;
            }
            while(right>=i){
                if(nums[i]>nums[right])
                    right--;
                    
                else
                    break;
            }
            list.add(nums[i]);
            
            
        }
        return list;
    }
}