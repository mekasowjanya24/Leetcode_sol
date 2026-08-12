class Solution {
    public int minOperations(String s) {
        int n = s.length();
        
        // Count descents
        int descents = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                descents++;
            }
        }
        
        if (descents == 0) return 0;
        
        // A string of length 2 that's unsorted cannot be fixed
        // (only proper substrings are single chars - useless)
        if (n == 2) return -1;
        
        return descents;
    }
}