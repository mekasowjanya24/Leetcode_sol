class Solution {
public int minOperations(String s) {
    int n = s.length();

    char[] sorted = s.toCharArray();
    java.util.Arrays.sort(sorted);

    if (new String(sorted).equals(s)) return 0;
    if (n == 2) return -1;

    // find how many operations needed
    // each op can fix one "descent" in the string
    // but we also need to handle chars needing multiple moves
    
    int ops = 0;
    char[] current = s.toCharArray();
    
    for (int i = 0; i < n; i++) {
        if (current[i] != sorted[i]) {
            // find where sorted[i] is in current
            int j = i + 1;
            while (j < n && current[j] != sorted[i]) j++;
            
            // sort from i to j (one operation)
            java.util.Arrays.sort(current, i, j + 1);
            ops++;
        }
    }
    
    return ops;
}
}
