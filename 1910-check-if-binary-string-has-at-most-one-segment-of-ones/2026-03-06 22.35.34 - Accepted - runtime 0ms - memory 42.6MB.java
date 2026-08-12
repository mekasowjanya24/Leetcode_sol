class Solution {
    public boolean checkOnesSegment(String s) {
        boolean seenzero=false;
       for(int i=0;i<s.length();i++){
        if(s.charAt(i)=='1'){
            if(seenzero){
                return false;
            }
        }
           else{
            seenzero=true;
           } 
        }
        return true;   
    }
}