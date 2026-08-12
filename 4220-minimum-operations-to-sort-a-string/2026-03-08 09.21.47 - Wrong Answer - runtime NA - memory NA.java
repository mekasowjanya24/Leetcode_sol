import java.util.*;

class Solution {
    public int minOperations(String s) {

        int n = s.length();

        char[] arr = s.toCharArray();
        char[] sorted = s.toCharArray();
        Arrays.sort(sorted);

        if (Arrays.equals(arr, sorted))
            return 0;

        if (n == 2)
            return -1;

        int j = n - 1;

        for (int i = n - 1; i >= 0 && j >= 0; i--) {
            if (arr[i] == sorted[j]) {
                j--;
            }
        }

        return j + 1;
    }
}