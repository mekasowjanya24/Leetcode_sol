class Solution {
    private Map<String, Integer> memo = new HashMap<>();
    
    public int minOperations(String s) {
        int n = s.length();
        char[] sorted = s.toCharArray();
        Arrays.sort(sorted);
        String t = new String(sorted);
        return solve(s, t, n);
    }
    
    private int solve(String s, String t, int n) {
        if (s.equals(t)) return 0;
        if (n == 2) return -1;
        if (memo.containsKey(s)) return memo.get(s);
        
        // Check dirty region
        int l = 0, r = n - 1;
        while (l < n && s.charAt(l) == t.charAt(l)) l++;
        while (r >= 0 && s.charAt(r) == t.charAt(r)) r--;
        if (l > 0 || r < n - 1) { memo.put(s, 1); return 1; }
        
        // Greedy self-sufficient block decomposition
        int[] diff = new int[26];
        int nonZero = 0, ops = 0, blockStart = 0;
        boolean blockDirty = false;
        
        for (int i = 0; i < n - 1; i++) {
            int cs = s.charAt(i)-'a', ct = t.charAt(i)-'a';
            if (diff[cs]==0) nonZero++; diff[cs]++;
            if (diff[cs]==0) nonZero--;
            if (diff[ct]==0) nonZero++; diff[ct]--;
            if (diff[ct]==0) nonZero--;
            if (s.charAt(i) != t.charAt(i)) blockDirty = true;
            if (nonZero == 0) {
                if (blockDirty) ops++;
                blockStart = i+1; diff = new int[26]; nonZero = 0; blockDirty = false;
            }
        }
        if (s.charAt(n-1) != t.charAt(n-1)) blockDirty = true;
        if (blockDirty) ops++;
        
        // If multiple blocks found, that's the answer
        if (blockStart > 0) { memo.put(s, ops); return ops; }
        
        // Whole string is one dirty block - check if solvable in 2 ops
        // Try all first operations, check if result needs only 1 more op
        for (int ll = 0; ll < n; ll++) {
            for (int rr = ll+1; rr < n; rr++) {
                if (ll==0 && rr==n-1) continue;
                char[] tmp = s.toCharArray();
                Arrays.sort(tmp, ll, rr+1);
                String nxt = new String(tmp);
                if (nxt.equals(t)) { memo.put(s, 1); return 1; } // shouldn't happen
                // Check if nxt can be solved in 1 op
                int nl = 0, nr = n-1;
                while (nl < n && nxt.charAt(nl)==t.charAt(nl)) nl++;
                while (nr >= 0 && nxt.charAt(nr)==t.charAt(nr)) nr--;
                if (nl > 0 || nr < n-1) { // dirty region is proper → 1 op
                    memo.put(s, 2); return 2;
                }
            }
        }
        
        // Cannot do in 2 ops - try 3
        for (int ll = 0; ll < n; ll++) {
            for (int rr = ll+1; rr < n; rr++) {
                if (ll==0 && rr==n-1) continue;
                char[] tmp = s.toCharArray();
                Arrays.sort(tmp, ll, rr+1);
                String nxt = new String(tmp);
                int sub = solve(nxt, t, n);
                if (sub == 2) { memo.put(s, 3); return 3; }
            }
        }
        
        // Need more (rare - keep recursing)
        int best = Integer.MAX_VALUE;
        for (int ll = 0; ll < n; ll++) {
            for (int rr = ll+1; rr < n; rr++) {
                if (ll==0 && rr==n-1) continue;
                char[] tmp = s.toCharArray();
                Arrays.sort(tmp, ll, rr+1);
                String nxt = new String(tmp);
                int sub = solve(nxt, t, n);
                if (sub != -1) best = Math.min(best, 1+sub);
            }
        }
        int result = best == Integer.MAX_VALUE ? -1 : best;
        memo.put(s, result);
        return result;
    }
}