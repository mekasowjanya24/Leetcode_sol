class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];
        }
        if(sum%3!=0)
        return false;
        int target=sum/3;
        int runningsum=0;
        int count=0;
        for(int i=0;i<arr.length;i++){
            runningsum+=arr[i];
            if(runningsum==target){
                count++;
                runningsum=0;
                if(count==3)return true;
            }
        }
        return false;
    }
}