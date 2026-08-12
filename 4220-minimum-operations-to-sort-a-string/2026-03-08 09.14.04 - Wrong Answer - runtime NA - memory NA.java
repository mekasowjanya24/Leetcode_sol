import java.util.*;

class Solution {
    public int minOperations(String s) {

        char[] arr = s.toCharArray();
        char[] sorted = s.toCharArray();
        Arrays.sort(sorted);

        if (Arrays.equals(arr, sorted)) 
            return 0;

        if (s.length() == 2) 
            return -1;

        return 1;
    }
}