class Solution {
 public int minOperations(String s) {
    // get target sorted string
    char[] arr = s.toCharArray();
    java.util.Arrays.sort(arr);
    String target = new String(arr);
    
    // already sorted
    if (s.equals(target)) return 0;
    
    // find leftmost and rightmost mismatch
    int left = 0;
    int right = s.length() - 1;
    
    while (left < s.length() && s.charAt(left) == target.charAt(left))
        left++;
    while (right >= 0 && s.charAt(right) == target.charAt(right))
        right--;
    
    // if mismatch spans entire string → impossible
    if (left == 0 && right == s.length() - 1) return -1;
    
    // count drops (operations needed)
    int drops = 0;
    for (int i = 0; i < s.length() - 1; i++) {
        if (s.charAt(i) > s.charAt(i + 1)) drops++;
    }
    
    return drops;
}


}