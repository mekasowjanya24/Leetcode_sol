class Solution {
    public long countSubarrays(int[] nums, int k, int m) {
        int n = nums.length;
        long count = 0;

        for (int left = 0; left < n; left++) {
            Map<Integer, Integer> freq = new HashMap<>();
            int distinct = 0;
            for (int right = left; right < n; right++) {
                freq.merge(nums[right], 1, Integer::sum);
                if (freq.get(nums[right]) == m) distinct++;
                if (distinct == k) count++;
                if (distinct > k) break;
            }
        }
        return count;
    }
}