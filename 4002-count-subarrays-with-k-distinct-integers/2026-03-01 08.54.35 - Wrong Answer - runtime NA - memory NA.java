class Solution {
    public long countSubarrays(int[] nums, int k, int m) {
        int n = nums.length;
        long result = 0;
        Map<Integer, Integer> f1 = new HashMap<>(), f2 = new HashMap<>();
        int lo = 0, hi = 0, d1 = 0, q1 = 0, d2 = 0, q2 = 0;

        for (int r = 0; r < n; r++) {
            // Expand both windows with nums[r]
            f1.merge(nums[r], 1, Integer::sum);
            if (f1.get(nums[r]) == 1) d1++;
            if (f1.get(nums[r]) == m) q1++;

            f2.merge(nums[r], 1, Integer::sum);
            if (f2.get(nums[r]) == 1) d2++;
            if (f2.get(nums[r]) == m) q2++;

            // lo: shrink while dist > k OR qual < k
            // → lo is leftmost fully valid left (dist==k, qual==k)
            while (d1 > k || (d1 == k && q1 < k)) {
                int nf = f1.merge(nums[lo], -1, Integer::sum);
                if (nf == 0) { d1--; f1.remove(nums[lo]); }
                else if (nf == m - 1) q1--;
                lo++;
            }

            // hi: shrink while dist > k only
            // → hi is leftmost left where dist == k
            while (d2 > k) {
                int nf = f2.merge(nums[hi], -1, Integer::sum);
                if (nf == 0) { d2--; f2.remove(nums[hi]); }
                else if (nf == m - 1) q2--;
                hi++;
            }

            // valid lefts = [lo, hi] where dist==k and qual==k
            // lo = leftmost fully valid, hi = rightmost with dist==k
            if (d1 == k && q1 == k) {
                result += hi - lo + 1;
            }
        }
        return result;
    }
}