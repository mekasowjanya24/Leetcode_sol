class Solution {
    public long countSubarrays(int[] nums, int k, int m) {
        return f(nums, k, m) - f(nums, k + 1, m);
    }

    
    private long f(int[] nums, int k, int m) {
        Map<Integer, Integer> freq = new HashMap<>();
        long result = 0;
        int n = nums.length;
        int left = 0;
        int qualified = 0;  
        int unqualified = 0; 

        for (int right = 0; right < n; right++) {
            int val = nums[right];
            freq.merge(val, 1, Integer::sum);
            int f = freq.get(val);
            if (f == m) {
                qualified++;
                unqualified--;
            } else if (f == 1) {
                unqualified++; 
            }

            while (unqualified > 0 && left <= right) {
                int lval = nums[left];
                int lf = freq.merge(lval, -1, Integer::sum);
                if (lf == m - 1) {
                    qualified--;
                    unqualified++;
                } else if (lf == 0) {
                    unqualified--;
                    freq.remove(lval);
                }
                left++;
            }

           
            if (qualified >= k) {
                result += n - right;
            }
        }
        return result;
    }
}