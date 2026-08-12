class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n=nums1.length;
        int count=0;
      HashMap<Integer,Integer>map=new HashMap<>();
      for(int i:nums1){
        for(int j:nums2){
            int sum=i+j;
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
      }
      for(int i:nums3){
        for(int j:nums4){
            int need=-(i+j);
            count=count+map.getOrDefault(need,0);
        }
      }
    return count;
    }

}