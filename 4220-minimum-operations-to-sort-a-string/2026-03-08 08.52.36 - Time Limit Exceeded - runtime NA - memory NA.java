class Solution {
    public int minOperations(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String target = new String(arr);
        
        if (s.equals(target)) return 0;
        
        int n = s.length();
        if (n <= 1) return 0;
        
        // BFS for minimum operations
        Map<String, Integer> visited = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        visited.put(s, 0);
        queue.offer(s);
        
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            int steps = visited.get(cur);
            
            for (int l = 0; l < n; l++) {
                for (int r = l + 1; r < n; r++) {
                    // Skip the entire string
                    if (l == 0 && r == n - 1) continue;
                    
                    char[] tmp = cur.toCharArray();
                    Arrays.sort(tmp, l, r + 1);
                    String next = new String(tmp);
                    
                    if (next.equals(target)) return steps + 1;
                    
                    if (!visited.containsKey(next)) {
                        visited.put(next, steps + 1);
                        queue.offer(next);
                    }
                }
            }
        }
        
        return -1;
    }
}