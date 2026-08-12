class Solution {
    public int[] plusOne(int[] digits) {
        StringBuilder sb=new StringBuilder();
        for(int n:digits)
        sb.append(n);
        java.math.BigInteger result= new java.math.BigInteger(sb.toString())
                .add(java.math.BigInteger.ONE);
        String s=result.toString();
        int [] arr=new int[s.length()];
        for(int i=0;i<s.length();i++){
            arr[i]=Character.getNumericValue(s.charAt(i));
        }
        return arr;
        
    }
}