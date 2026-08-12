class Solution {
 public int minOperations(String s) {
 
    int n = s.length();
    
    // count drops
    int drops = 0;
    for (int i = 0; i < n - 1; i++) {
        if (s.charAt(i) > s.charAt(i + 1)) drops++;
    }
    
    // already sorted
    if (drops == 0) return 0;
    
    // length 2 with a drop → only fix = entire string → impossible
    if (n == 2) return -1;
    
    // check if any single proper substring sort can achieve sorted
    // -1 only when ALL characters are descending (like "zyx", "gf", "dcba")
    // because each fix only handles one region at a time
    char[] arr = s.toCharArray();
    java.util.Arrays.sort(arr);
    String target = new String(arr);
    
    // try if one operation fixes it
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (i == 0 && j == n - 1) continue; // skip entire string
            char[] temp = s.toCharArray();
            java.util.Arrays.sort(temp, i, j + 1);
            if (new String(temp).equals(target)) return 1;
        }
    }
    
    return drops;
}
}