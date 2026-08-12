class Solution {
    public int minOperations(String s) {
     
        int n = s.length();
        
        // Count descents (positions where s[i] > s[i+1])
        // Each descent needs exactly one operation to fix
        // One operation can fix one descent without creating new ones
        
        int descents = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                descents++;
            }
        }
        
        // If already sorted
        if (descents == 0) return 0;
        
        // Each operation sorts a substring → fixes exactly one "block"
        // Minimum operations = number of descents
        return descents;
    }
}
    