class Solution {
    public int lengthOfLastWord(String s) {
        int n=s.length();
        int left=n-1;
        int count=0;
        while(left>=0 && s.charAt(left)==' ')
        left--;
        while(left>=0 && s.charAt(left)!=' '){
            count++;
            left--;
        }
        return count;
    }
}