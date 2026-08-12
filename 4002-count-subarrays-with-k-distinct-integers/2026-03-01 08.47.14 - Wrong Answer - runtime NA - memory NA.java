class Solution {
    public long countSubarrays(int[] nums, int k, int m) {
        return f(nums, k, m) - f(nums, k + 1, m);
    }
    
    // Count subarrays with at least k distinct integers,
    // each appearing at least m times
    private long f(int[] nums, int k, int m) {
        Map<Integer, Integer> freq = new HashMap<>();
        long result = 0;
        int n = nums.length;
        int left = 0;
        int qualified = 0; // distinct elements with freq >= m
        
        for (int right = 0; right < n; right++) {
            freq.merge(nums[right], 1, Integer::sum);
            if (freq.get(nums[right]) == m) qualified++;
            
            while (qualified >= k) {
                result += n - right;
                if (freq.merge(nums[left], -1, Integer::sum) == m - 1)
                    qualified--;
                left++;
            }
        }
        return result;
    }
}