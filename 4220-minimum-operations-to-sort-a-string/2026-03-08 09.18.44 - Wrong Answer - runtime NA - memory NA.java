class Solution {
    public int minOperations(String s) {

        int n = s.length();

        if (n == 1) return 0;

        if (n == 2) {
            return s.charAt(0) <= s.charAt(1) ? 0 : -1;
        }

        int ans = 0;
        char minRight = s.charAt(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) > minRight) {
                ans++;
            } else {
                minRight = s.charAt(i);
            }
        }

        return ans;
    }
}