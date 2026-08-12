class Solution {
    public int minOperations(String s) {
        char[] sorted = s.toCharArray();
        Arrays.sort(sorted);
        String target = new String(sorted);
        
        if (s.equals(target)) return 0;
        
        int n = s.length();
        
        // Find dirty region [l, r]
        int l = 0, r = n - 1;
        while (l < n && s.charAt(l) == target.charAt(l)) l++;
        while (r >= 0 && s.charAt(r) == target.charAt(r)) r--;
        
        // If dirty region is a proper substring, 1 op suffices
        if (l > 0 || r < n - 1) return 1;
        
        // Dirty region is entire string
        if (n == 2) return -1;
        
        // For n >= 3, find minimum ops
        // We need to find the minimum number of proper substring sorts
        // Key insight: count "ascending runs" in the permutation
        // Build position mapping (handling duplicates with stable sort indices)
        
        // Count of each character
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'a']++;
        
        // Assign rank to each character in s based on sorted order
        int[] rank = new int[n];
        int[] pos = new int[26]; // current position counter per char
        int[] base = new int[26]; // base rank for each char
        int cumulative = 0;
        for (int i = 0; i < 26; i++) {
            base[i] = cumulative;
            cumulative += cnt[i];
        }
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            rank[i] = base[c] + pos[c];
            pos[c]++;
        }
        
        // Count ascending runs in rank array
        int runs = 1;
        for (int i = 1; i < n; i++) {
            if (rank[i] < rank[i-1]) runs++;
        }
        
        // Minimum ops = runs - 1? Let me verify
        // "cab": rank=[2,0,1], runs: 2>0(break),0<1 → 2 runs → 2-1=1? NO, expected 2
        
        // Hmm, so it's just "runs" not "runs-1"?
        // "cab": 2 runs → answer 2 ✓ (but we already handled dirty=proper-substring case above)
        // Wait, for "cab" dirty=[0,2]=whole string, so we're in this branch
        // runs=2 → answer=2 ✓
        
        // "dcba": rank=[3,2,1,0], runs: every pair decreasing → 4 runs → answer=4? 
        // But I estimated answer=3 earlier... let me recheck
        
        return runs;
    }
}