class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n=nums1.length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    for(int l=0;l<n;l++){
                        long sum=(long)nums1[i]+nums2[j]+nums3[k]+nums4[l];
                        if(sum==0)
                        count++;
                }
            }
        }
    }
    return count;
    }

}