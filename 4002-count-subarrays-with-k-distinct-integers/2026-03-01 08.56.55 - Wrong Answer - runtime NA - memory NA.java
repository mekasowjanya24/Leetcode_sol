class Solution {
    public long countSubarrays(int[] nums, int k, int m) {
        int n = nums.length;
        long result = 0;
        Map<Integer, Integer> f1 = new HashMap<>(), f2 = new HashMap<>();
        int p1 = 0, p2 = 0, d1 = 0, q1 = 0, d2 = 0, q2 = 0;

        for (int r = 0; r < n; r++) {
            // Window 1: shrink only when dist > k
            f1.merge(nums[r], 1, Integer::sum);
            if (f1.get(nums[r]) == 1) d1++;
            if (f1.get(nums[r]) == m) q1++;
            while (d1 > k) {
                int nf = f1.merge(nums[p1], -1, Integer::sum);
                if (nf == 0) { d1--; f1.remove(nums[p1]); }
                else if (nf == m - 1) q1--;
                p1++;
            }

            // Window 2: shrink when dist > k OR qual < k
            f2.merge(nums[r], 1, Integer::sum);
            if (f2.get(nums[r]) == 1) d2++;
            if (f2.get(nums[r]) == m) q2++;
            while (d2 > k || (d2 == k && q2 < k)) {
                int nf = f2.merge(nums[p2], -1, Integer::sum);
                if (nf == 0) { d2--; f2.remove(nums[p2]); }
                else if (nf == m - 1) q2--;
                p2++;
            }

            // p1 = leftmost left with dist==k
            // p2 = leftmost left with dist==k AND qual==k
            // valid lefts = [p2, p1], count = p2 - p1 + 1... 
            // NO: p2 >= p1 (stricter), so valid range = [p2..something]
            // But we want lefts where dist==k AND qual==k
            // Those are in [p2, p1] since p1 is leftmost dist==k boundary on right side
            // Wait: as left increases from p1, dist stays k until it drops.
            // p2 is where qual first becomes k (leftmost fully valid)
            // So valid lefts = [p1, p2] only if p2 >= p1

            if (d1 == k && q1 == k) result += p2 - p1;
        }
        return result;
    }
}