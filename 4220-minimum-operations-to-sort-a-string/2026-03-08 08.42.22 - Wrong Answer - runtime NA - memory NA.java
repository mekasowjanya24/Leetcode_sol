class Solution {
public int minOperations(String s) {

    int n = s.length();
    char[] sorted = s.toCharArray();
    java.util.Arrays.sort(sorted);

    if (new String(sorted).equals(s)) return 0;

    int ops = 0;
    char[] current = s.toCharArray();

    for (int i = 0; i < n; i++) {
        if (current[i] != sorted[i]) {
            int j = i + 1;
            while (j < n && current[j] != sorted[i]) j++;

            // if operation spans entire string → impossible
            if (i == 0 && j == n - 1) return -1;

            java.util.Arrays.sort(current, i, j + 1);
            ops++;
        }
    }
    
    return ops;
}
}
