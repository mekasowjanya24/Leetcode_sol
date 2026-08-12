class Solution {
    public int minOperations(String s) {
        String target = s.chars().sorted()
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
        
        if (s.equals(target)) return 0;
        
        int n = s.length();
        if (n == 1) return 0;
        
        // BFS
        Map<String, Integer> dist = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        dist.put(s, 0);
        q.add(s);
        
        while (!q.isEmpty()) {
            String cur = q.poll();
            int d = dist.get(cur);
            
            for (int l = 0; l < n; l++) {
                for (int r = l + 1; r < n; r++) {
                    if (l == 0 && r == n - 1) continue; // skip full string
                    
                    char[] arr = cur.toCharArray();
                    Arrays.sort(arr, l, r + 1);
                    String next = new String(arr);
                    
                    if (!dist.containsKey(next)) {
                        if (next.equals(target)) return d + 1;
                        dist.put(next, d + 1);
                        q.add(next);
                    }
                }
            }
        }
        
        return -1; // unreachable for n >= 3
    }
}