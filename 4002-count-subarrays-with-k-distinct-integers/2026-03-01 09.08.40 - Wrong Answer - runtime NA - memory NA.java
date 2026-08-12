class Solution {
    public long countSubarrays(int[] nums, int k, int m) {
        return solve(nums, k, m) - solve(nums, k - 1, m);
    }

    // Count subarrays where number of integers with freq >= m is AT MOST k
    private long solve(int[] nums, int k, int m) {
        if (k < 0) return 0;
        Map<Integer, Integer> freq = new HashMap<>();
        long count = 0;
        int left = 0, valid = 0;

        for (int right = 0; right < nums.length; right++) {
            freq.merge(nums[right], 1, Integer::sum);
            if (freq.get(nums[right]) == m) valid++;

            while (valid > k) {
                if (freq.merge(nums[left], -1, Integer::sum) == m - 1) valid--;
                left++;
            }

            count += right - left + 1;
        }
        return count;
    }
}