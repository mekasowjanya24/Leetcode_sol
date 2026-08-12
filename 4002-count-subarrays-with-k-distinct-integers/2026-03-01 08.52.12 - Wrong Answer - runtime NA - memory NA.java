class Solution {
    public long countSubarrays(int[] nums, int k, int m) {
        int n = nums.length;
        long result = 0;
        Map<Integer, Integer> freq1 = new HashMap<>(), freq2 = new HashMap<>();
        int lo = 0, hi = 0;
        int dist1 = 0, qual1 = 0; 
        int dist2 = 0, qual2 = 0; 
        
        for (int right = 0; right < n; right++) {
            int v = nums[right];
            
            freq1.merge(v, 1, Integer::sum);
            if (freq1.get(v) == 1) dist1++;
            if (freq1.get(v) == m) qual1++;
            
            freq2.merge(v, 1, Integer::sum);
            if (freq2.get(v) == 1) dist2++;
            if (freq2.get(v) == m) qual2++;
            
          
            while (dist1 > k) {
                int lv = nums[lo];
                if (freq1.merge(lv, -1, Integer::sum) == 0) { dist1--; freq1.remove(lv); }
                else if (freq1.get(lv) == m - 1) qual1--;
                lo++;
            }
            
          
            while (dist2 == k && qual2 == k) {
                int lv = nums[hi];
                int nf = freq2.merge(lv, -1, Integer::sum);
                if (nf == 0) { dist2--; freq2.remove(lv); }
                else if (nf == m - 1) qual2--;
                hi++;
            }
            
            
            if (dist1 == k && qual1 == k) {
                result += hi - lo;
            }
        }
        return result;
    }
}