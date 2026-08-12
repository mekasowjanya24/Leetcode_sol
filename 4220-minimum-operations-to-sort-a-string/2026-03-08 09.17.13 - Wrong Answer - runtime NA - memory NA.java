import java.util.*;

class Solution {
    public int minOperations(String s) {

        char[] arr = s.toCharArray();
        char[] sorted = s.toCharArray();
        Arrays.sort(sorted);

        if (Arrays.equals(arr, sorted))
            return 0;

        int n = s.length();

        if (n == 2)
            return -1;

        int l = 0;
        while (l < n && arr[l] == sorted[l]) l++;

        int r = n - 1;
        while (r >= 0 && arr[r] == sorted[r]) r--;

        if (l == 0 && r == n - 1)
            return 2;

        char[] temp = arr.clone();
        Arrays.sort(temp, l, r + 1);

        if (Arrays.equals(temp, sorted))
            return 1;

        return 2;
    }
}