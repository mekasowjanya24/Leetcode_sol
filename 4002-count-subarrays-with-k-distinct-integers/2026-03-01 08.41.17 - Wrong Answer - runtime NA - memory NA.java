class Solution {
    public long countSubarrays(int[] nums, int k, int m) {
        return atMost(nums, k, m) - atMost(nums, k - 1, m);
    }
    
    private long atMost(int[] nums, int k, int m) {
   
        Map<Integer, Integer> freq = new HashMap<>();
        long result = 0;
        int left = 0;
        int qualifiedCount = 0;
        
        for (int right = 0; right < nums.length; right++) {
            freq.merge(nums[right], 1, Integer::sum);
            if (freq.get(nums[right]) == m) {
                qualifiedCount++;
            }
            
           
            while (qualifiedCount > k) {
                freq.merge(nums[left], -1, Integer::sum);
                if (freq.get(nums[left]) == m - 1) {
                    qualifiedCount--;
                }
                left++;
            }
            
            result += (right - left + 1);
        }
        
        return result;
    }
}
        
    
