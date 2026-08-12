class Solution {
    private int[] prefix;
    private int enc, flat;
    private Map<Long, Long> memo = new HashMap<>();
    
    public long minCost(String s, int encCost, int flatCost) {
        int n = s.length();
        enc = encCost;
        flat = flatCost;
        
        prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (s.charAt(i) == '1' ? 1 : 0);
        }
        
        return solve(0, n - 1);
    }
    
    private long solve(int l, int r) {
        int len = r - l + 1;
        int ones = prefix[r + 1] - prefix[l];
        
        // Base: no sensitive elements → flatCost
        if (ones == 0) return flat;
        
        // Cost if we keep this segment as-is
        long keep = (long) len * ones * enc;
        
        // Can only split if even length
        if (len % 2 != 0) return keep;
        
        // Check memo
        long key = (long) l * 100001 + r;
        if (memo.containsKey(key)) return memo.get(key);
        
        int mid = (l + r) / 2;
        long split = solve(l, mid) + solve(mid + 1, r);
        
        long result = Math.min(keep, split);
        memo.put(key, result);
        return result;
    }
}