class Solution {
    public int minOperations(String s) {
         int drops = 0;
    
    for (int i = 0; i < s.length() - 1; i++) {
        if (s.charAt(i) > s.charAt(i + 1)) {
            drops++;
        }
    }
    
    return drops;
    }
}