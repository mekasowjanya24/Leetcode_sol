class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;
        int maxarea=Integer.MIN_VALUE;
        while(left<right){
            int l=Math.min(height[right],height[left]);
            int b=right-left;
            int area=l*b;
            maxarea=Math.max(maxarea,area);
            if(height[left]<height[right])
            left++;
            else
            right--;
        }
        return maxarea;
    }
}