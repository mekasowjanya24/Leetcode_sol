class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        int start =toSeconds(startTime);
        int end=toSeconds(endTime);
        int diff=end-start;
        if(diff<0){
            diff=diff+24*3600;
        }
        return diff;
    }
    private int toSeconds(String time){
    String[] parts=time.split(":");
    int h=Integer.parseInt(parts[0]);
    int m=Integer.parseInt(parts[1]);
    int s=Integer.parseInt(parts[2]);
    return h*3600+m*60+s;
}
}