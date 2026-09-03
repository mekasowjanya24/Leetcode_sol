class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //sot by end values
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
      int end=intervals[0][1];
      int count=0;
      for(int curr=1;curr<intervals.length;curr++){
        if(intervals[curr][0]<end)
        count++;
        else
        end=intervals[curr][1];

      }
      return count;

    }
}