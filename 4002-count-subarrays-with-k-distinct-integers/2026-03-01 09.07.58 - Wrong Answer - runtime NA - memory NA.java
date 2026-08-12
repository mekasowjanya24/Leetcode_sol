class Solution {
    public long countSubarrays(int[] nums, int k, int m) {
        return atMost(nums, k, m) - atMost(nums, k - 1, m);
    }

    private long atMost(int[] nums, int k, int m) {
        Map<Integer, Integer> freq = new HashMap<>();
        long count = 0;
        int left = 0, valid = 0;

        for (int right = 0; right < nums.length; right++) {
            freq.merge(nums[right], 1, Integer::sum);
            if (freq.get(nums[right]) == m) valid++;

            while (valid > k) {
                freq.merge(nums[left], -1, Integer::sum);
                if (freq.get(nums[left]) == m - 1) valid--;
                left++;
            }

            count += right - left + 1;
        }
        return count;
    }
}