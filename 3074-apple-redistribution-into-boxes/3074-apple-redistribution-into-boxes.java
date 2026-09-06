class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
    Arrays.sort(apple);
    Arrays.sort(capacity);
    int n=apple.length;
    int m=capacity.length;
    int sum=0;
    for(int i=0;i<n;i++){
        sum=sum+apple[i];
    }
   
    int cap=0;
    int count=0;
    for(int i=m-1;i>=0;i--){
        cap=cap+capacity[i];
        count++;
        if(cap>=sum)
        return count;
        
    }
        return count;
    }
}