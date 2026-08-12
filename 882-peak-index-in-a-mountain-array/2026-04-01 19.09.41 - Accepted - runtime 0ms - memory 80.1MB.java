class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low=0;
        int high=arr.length-1;
       // int ans=Integer.MIN_VALUE;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            if( arr[mid]<arr[mid+1]){
               // ans=arr[mid];
                low=mid+1;
            }
            else{
                high=mid-1;
            }
           
        }
        return low;
        
    }
}