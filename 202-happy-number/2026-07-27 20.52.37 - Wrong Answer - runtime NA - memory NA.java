class Solution {
    public boolean isHappy(int n) {
        if(n==1)
        return true;
        if(n<9)
        return false;
        while(n>9){
            int a=n%10;
            int b=n/10;
            n=a*a-b*b;
        }
        return true;
    }
}