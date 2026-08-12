class Solution {
 public int minOperations(String s) {
    int drops = 0;
    
    for (int i = 0; i < s.length() - 1; i++) {
        if (s.charAt(i) > s.charAt(i + 1)) {
            drops++;
        }
    }
    
    // impossible case:
    // only 1 drop AND it spans the whole string
    // meaning first char > rest of string (entire string unsorted as one block)
    if (drops == 1) {
        // check if entire string needs sorting
        // i.e. s[0] is the only problem and removing it sorts the rest
        char[] sorted = s.toCharArray();
        java.util.Arrays.sort(sorted);
        String target = new String(sorted);
        
        // if only way to fix is sorting whole string → impossible
        if (s.substring(1).equals(target.substring(1)) ||
            s.substring(0, s.length()-1).equals(target.substring(0, s.length()-1))) {
            // check if any proper substring sort can fix it
            return canFix(s, target) ? 1 : -1;
        }
    }
    
    return drops == 0 ? 0 : drops;
}

private boolean canFix(String s, String target) {
    int n = s.length();
    // try all proper substrings
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (i == 0 && j == n - 1) continue; // skip entire string
            char[] arr = s.toCharArray();
            java.util.Arrays.sort(arr, i, j + 1);
            if (new String(arr).equals(target)) return true;
        }
    }
    return false;
}

}