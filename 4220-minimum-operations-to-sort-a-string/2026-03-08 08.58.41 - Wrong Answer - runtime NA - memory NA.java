class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String t = new String(arr);
        
        if (s.equals(t)) return 0;
        if (n == 2) return -1;
        
        // Find dirty region
        int l = 0, r = n - 1;
        while (l < n && s.charAt(l) == t.charAt(l)) l++;
        while (r >= 0 && s.charAt(r) == t.charAt(r)) r--;
        
        // Dirty region is proper substring → 1 op
        if (l > 0 || r < n - 1) return 1;
        
        // Whole string dirty: count self-contained block boundaries
        int[] diff = new int[26];
        int nonZero = 0, splits = 0;
        
        for (int i = 0; i < n - 1; i++) {
            int cs = s.charAt(i) - 'a';
            int ct = t.charAt(i) - 'a';
            
            if (diff[cs] == 0) nonZero++;
            diff[cs]++;
            if (diff[cs] == 0) nonZero--;
            
            if (diff[ct] == 0) nonZero++;
            diff[ct]--;
            if (diff[ct] == 0) nonZero--;
            
            if (nonZero == 0) splits++;
        }
        
        // splits+1 blocks total. Each block is a proper substring.
        // If splits==0: the only block is the whole string → need 2 ops to break it
        return Math.max(2, splits + 1);
    }
}