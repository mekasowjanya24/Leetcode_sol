class Solution {
    private Map<String, Integer> memo = new HashMap<>();
    
    public int minOperations(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String t = new String(arr);
        return solve(s, t, n);
    }
    
    private int solve(String s, String t, int n) {
        if (s.equals(t)) return 0;
        if (n == 2) return -1;
        if (memo.containsKey(s)) return memo.get(s);
        
        // Find dirty region
        int l = 0, r = n - 1;
        while (l < n && s.charAt(l) == t.charAt(l)) l++;
        while (r >= 0 && s.charAt(r) == t.charAt(r)) r--;
        
        if (l > 0 || r < n - 1) { memo.put(s, 1); return 1; }
        
        // Count self-contained blocks greedily
        int[] diff = new int[26];
        int nonZero = 0, splits = 0;
        for (int i = 0; i < n - 1; i++) {
            int cs = s.charAt(i) - 'a', ct = t.charAt(i) - 'a';
            if (diff[cs]++ == 0) nonZero++; if (diff[cs] == 0) nonZero--;
            if (diff[ct] == 0) nonZero++; diff[ct]--; if (diff[ct] == 0) nonZero--;
            if (nonZero == 0) splits++;
        }
        
        if (splits > 0) { memo.put(s, splits + 1); return splits + 1; }
        
        // splits == 0: must try all possible first operations, pick best
        int best = Integer.MAX_VALUE;
        for (int ll = 0; ll < n; ll++) {
            for (int rr = ll + 1; rr < n; rr++) {
                if (ll == 0 && rr == n - 1) continue;
                // Only try if not already sorted
                boolean needSort = false;
                for (int k = ll; k < rr; k++) 
                    if (s.charAt(k) > s.charAt(k+1)) { needSort = true; break; }
                if (!needSort) continue;
                
                char[] tmp = s.toCharArray();
                Arrays.sort(tmp, ll, rr + 1);
                String nxt = new String(tmp);
                int sub = solve(nxt, t, n);
                if (sub != -1) best = Math.min(best, 1 + sub);
            }
        }
        
        int result = best == Integer.MAX_VALUE ? -1 : best;
        memo.put(s, result);
        return result;
    }
}