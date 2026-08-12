import java.util.*;

class Solution {
    public int minOperations(String s) {

        char[] arr = s.toCharArray();
        char[] sorted = s.toCharArray();
        Arrays.sort(sorted);

        int n = s.length();

        int i = n - 1;
        int j = n - 1;

        while (i >= 0) {
            if (arr[i] == sorted[j]) {
                j--;
            }
            i--;
        }

        return j + 1;
    }
}