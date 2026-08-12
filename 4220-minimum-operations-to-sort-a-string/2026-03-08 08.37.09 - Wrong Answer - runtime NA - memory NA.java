class Solution {
public int minOperations(String s) {
    int n = s.length();
    if (n == 2) {
        return s.charAt(0) > s.charAt(1) ? -1 : 0;
    }
    
    char[] arr = s.toCharArray();
    char[] sorted = s.toCharArray();
    java.util.Arrays.sort(sorted);
    
    // already sorted
    if (new String(arr).equals(new String(sorted))) return 0;
    
    // count contiguous mismatched blocks
    int ops = 0;
    boolean inMismatch = false;
    
    for (int i = 0; i < n; i++) {
        if (arr[i] != sorted[i]) {
            if (!inMismatch) {
                ops++;           // new mismatched block starts
                inMismatch = true;
            }
        } else {
            inMismatch = false;  // matched region resets
        }
    }
    
    return ops;
}
}