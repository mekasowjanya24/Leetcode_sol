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
        
        int l = 0, r = n - 1;
        while (l < n && s.charAt(l) == t.charAt(l)) l++;
        while (r >= 0 && s.charAt(r) == t.charAt(r)) r--;
        if (l > 0 || r < n - 1) { memo.put(s, 1); return 1; }
        
        // Count dirty blocks
        int[] diff = new int[26];
        int nonZero = 0, ops = 0, blockStart = 0;
        boolean blockDirty = false;
        
        for (int i = 0; i < n - 1; i++) {
            int cs = s.charAt(i) - 'a', ct = t.charAt(i) - 'a';
            if (diff[cs] == 0) nonZero++; diff[cs]++;
            if (diff[cs] == 0) nonZero--;
            if (diff[ct] == 0) nonZero++; diff[ct]--;
            if (diff[ct] == 0) nonZero--;
            if (s.charAt(i) != t.charAt(i)) blockDirty = true;
            if (nonZero == 0) {
                if (blockDirty) ops++;
                blockStart = i + 1;
                diff = new int[26]; nonZero = 0; blockDirty = false;
            }
        }
        if (s.charAt(n-1) != t.charAt(n-1)) blockDirty = true;
        if (blockDirty) ops++;
        
        int result;
        if (ops <= 1 && blockStart == 0) {
            // Whole string is one dirty block
            // Check if any character repeats → if so, always 2 ops
            boolean hasRepeat = false;
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                if (++freq[c - 'a'] > 1) { hasRepeat = true; break; }
            }
            
            if (hasRepeat) {
                result = 2;
            } else {
                // All distinct: max length 26, safe to BFS/recurse
                int best = Integer.MAX_VALUE;
                for (int ll = 0; ll < n; ll++) {
                    for (int rr = ll + 1; rr < n; rr++) {
                        if (ll == 0 && rr == n - 1) continue;
                        boolean needsSort = false;
                        for (int k = ll; k < rr; k++)
                            if (s.charAt(k) > s.charAt(k+1)) { needsSort = true; break; }
                        if (!needsSort) continue;
                        char[] tmp = s.toCharArray();
                        Arrays.sort(tmp, ll, rr + 1);
                        String nxt = new String(tmp);
                        int sub = solve(nxt, t, n);
                        if (sub != -1) best = Math.min(best, 1 + sub);
                    }
                }
                result = best == Integer.MAX_VALUE ? -1 : best;
            }
        } else {
            result = ops;
        }
        
        memo.put(s, result);
        return result;
    }
}