class Solution {
    public boolean isHappy(int n) {
        Set<Integer>set=new HashSet<>();
        while(n!=1 && set.add(n)){
            int sum=0;
            while(n>0){
                int d=n%10;
                sum=sum+d*d;
                n=n/10;
            }
            n=sum;
        }
        
        return n==1;
    }
}