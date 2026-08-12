class Solution {
public int minOperations(String s) {


    int n = s.length();
    char[] sorted = s.toCharArray();
    java.util.Arrays.sort(sorted);

    // already sorted
    if (new String(sorted).equals(s)) return 0;

    // ONLY impossible case
    if (n == 2) return -1;

    int ops = 0;
    char[] current = s.toCharArray();

    for (int i = 0; i < n; i++) {
        if (current[i] != sorted[i]) {
            int j = i + 1;
            while (j < n && current[j] != sorted[i]) j++;
            java.util.Arrays.sort(current, i, j + 1);
            ops++;
        }
    }

    
    return ops;
}
}
