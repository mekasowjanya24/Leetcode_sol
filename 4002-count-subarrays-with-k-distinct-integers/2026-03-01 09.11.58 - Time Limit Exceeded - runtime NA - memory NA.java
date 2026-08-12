class Solution {
    public long countSubarrays(int[] nums, int k, int m) {
        int n = nums.length;
        long count = 0;

        for (int left = 0; left < n; left++) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int right = left; right < n; right++) {
                freq.merge(nums[right], 1, Integer::sum);
                
                // Check: exactly k distinct AND all have freq >= m
                if (freq.size() == k) {
                    boolean allValid = true;
                    for (int v : freq.values()) {
                        if (v < m) { allValid = false; break; }
                    }
                    if (allValid) count++;
                }
                
                // Early exit: if any distinct count > k, no point continuing
                if (freq.size() > k) break;
            }
        }
        return count;
    }
}