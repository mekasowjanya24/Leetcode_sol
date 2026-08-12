class Solution {
    public long countSubarrays(int[] nums, int k, int m) {
        int n = nums.length;
        long result = 0;
        Map<Integer, Integer> f1 = new HashMap<>(), f2 = new HashMap<>();
        int lo = 0, hi = 0, d1 = 0, q1 = 0, d2 = 0, q2 = 0;

        for (int r = 0; r < n; r++) {
            // f1/lo: shrink when dist>k only → finds leftmost left with dist==k
            f1.merge(nums[r], 1, Integer::sum);
            if (f1.get(nums[r]) == 1) d1++;
            if (f1.get(nums[r]) == m) q1++;
            while (d1 > k) {
                int nf = f1.merge(nums[hi], -1, Integer::sum);
                if (nf == 0) { d1--; f1.remove(nums[hi]); }
                else if (nf == m - 1) q1--;
                hi++;
            }

            // f2/lo: shrink when dist>k OR qual<k → finds leftmost FULLY valid left
            f2.merge(nums[r], 1, Integer::sum);
            if (f2.get(nums[r]) == 1) d2++;
            if (f2.get(nums[r]) == m) q2++;
            while (d2 > k || (d2 == k && q2 < k)) {
                int nf = f2.merge(nums[lo], -1, Integer::sum);
                if (nf == 0) { d2--; f2.remove(nums[lo]); }
                else if (nf == m - 1) q2--;
                lo++;
            }

            // valid lefts in [hi, lo] all have dist==k and qual==k
            if (d1 == k && q1 == k) result += lo - hi + 1;
        }
        return result;
    }
}