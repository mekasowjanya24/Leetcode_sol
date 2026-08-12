class Solution {
    public long countSubarrays(int[] nums, int k, int m) {
        int n = nums.length;
        long result = 0;
        
        
        
        return f(nums, k, m) - f(nums, k + 1, m);
    }
    
  
    private long f(int[] nums, int k, int m) {
        Map<Integer, Integer> freq = new HashMap<>();
        long result = 0;
        int n = nums.length;
        int left = 0;
        int qualifiedCount = 0;
        
        for (int right = 0; right < n; right++) {
            freq.merge(nums[right], 1, Integer::sum);
            if (freq.get(nums[right]) == m) qualifiedCount++;
            
         
            
            while (qualifiedCount >= k && left <= right) {
                result += (n - right); 
                freq.merge(nums[left], -1, Integer::sum);
                if (freq.get(nums[left]) == m - 1) qualifiedCount--;
                left++;
            }
        }
        return result;
    }
}