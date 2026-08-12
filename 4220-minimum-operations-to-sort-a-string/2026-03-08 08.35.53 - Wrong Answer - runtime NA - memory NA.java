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
    
    // ONLY impossible case: length 2, not sorted
    // because only substring possible = entire string
    if (n == 2) return -1;
    
  
    return drops;
}
}