class Solution {
    public long countSubarrays(int[] nums, int k, int m) {
        int n = nums.length;
        long result = 0;
        
        for (int left = 0; left < n; left++) {
            Map<Integer, Integer> freq = new HashMap<>();
            int distinct = 0, qualified = 0;
            
            for (int right = left; right < n; right++) {
                int v = nums[right];
                freq.merge(v, 1, Integer::sum);
                int f = freq.get(v);
                if (f == 1) distinct++;
                if (f == m) qualified++;
                
                if (distinct > k) break; // can never have exactly k distinct
                if (distinct == k && distinct == qualified) result++; // all k appear >= m times
            }
        }
        return result;
    }
}