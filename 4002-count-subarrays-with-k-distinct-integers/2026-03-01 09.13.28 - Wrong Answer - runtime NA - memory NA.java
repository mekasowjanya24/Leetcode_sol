class Solution {
    public long countSubarrays(int[] nums, int k, int m) {
        return g(nums, k, m) - g(nums, k - 1, m);
    }

    private long g(int[] nums, int k, int m) {
        if (k < 0) return 0;
        Map<Integer, Integer> freq = new HashMap<>();
        long count = 0;
        int left = 0, belowM = 0;

        for (int right = 0; right < nums.length; right++) {
            int r = nums[right];
            freq.merge(r, 1, Integer::sum);
            if (freq.get(r) == 1)  belowM++; // brand new, below m
            if (freq.get(r) == m)  belowM--; // just hit m, no longer below

            while (freq.size() > k || belowM > 0) {
                int l = nums[left++];
                int lf = freq.get(l);
                if (lf == m)  belowM++; // dropping below m
                freq.merge(l, -1, Integer::sum);
                if (freq.get(l) == 0) {
                    freq.remove(l);
                    belowM--;             // was below m (lf<m), now gone
                }
            }

            count += right - left + 1;
        }
        return count;
    }
}