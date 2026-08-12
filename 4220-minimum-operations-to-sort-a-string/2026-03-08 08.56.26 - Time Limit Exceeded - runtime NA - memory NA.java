class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String target = new String(arr);
        
        if (s.equals(target)) return 0;
        if (n == 2) return -1;
        
        // Key insight: due to repeated chars, state space is much smaller
        // Use BFS but with better state representation
        
        // For each state, the "canonical" form matters
        // With small alphabet (a-e = 5 chars), many strings map to same state
        
        Map<String, Integer> dist = new HashMap<>();
        ArrayDeque<String> q = new ArrayDeque<>();
        dist.put(s, 0);
        q.add(s);
        
        while (!q.isEmpty()) {
            String cur = q.poll();
            int d = dist.get(cur);
            
            for (int l = 0; l < n; l++) {
                for (int r = l + 1; r < n; r++) {
                    if (l == 0 && r == n - 1) continue;
                    
                    // Only sort if this region is not already sorted
                    // (optimization: skip if s[l..r] already sorted)
                    boolean needsSort = false;
                    for (int k = l; k < r; k++) {
                        if (cur.charAt(k) > cur.charAt(k + 1)) {
                            needsSort = true;
                            break;
                        }
                    }
                    if (!needsSort) continue;
                    
                    char[] tmp = cur.toCharArray();
                    Arrays.sort(tmp, l, r + 1);
                    String nxt = new String(tmp);
                    
                    if (nxt.equals(target)) return d + 1;
                    if (!dist.containsKey(nxt)) {
                        dist.put(nxt, d + 1);
                        q.add(nxt);
                    }
                }
            }
        }
        
        return -1;
    }
}