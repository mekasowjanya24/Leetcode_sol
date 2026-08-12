class Solution {
    public boolean validPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
            left++;
            right--;
            }
            else if{
                left++;
                if(s.charAt(left)!=s.charAt(right))
                return false;
            }
            else {
                right--;
                if(s.charAt(left)!=s.charAt(right))
                return false;
            }
        }
        

        return true;
    }
}