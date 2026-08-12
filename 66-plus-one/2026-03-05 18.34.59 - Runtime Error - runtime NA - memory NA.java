class Solution {
    public int[] plusOne(int[] digits) {
        StringBuilder sb=new StringBuilder();
        for(int n:digits)
        sb.append(n);
        int result=Integer.parseInt(sb.toString())+1;
        String s=Integer.toString(result);
        int [] arr=new int[s.length()];
        for(int i=0;i<s.length();i++){
            arr[i]=Character.getNumericValue(s.charAt(i));
        }
        return arr;
        
    }
}