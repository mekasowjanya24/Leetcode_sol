class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;
        int low=0;
        int high=col-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int r=maxele(mat,mid);
            int left=mid-1>=0?mat[r][mid-1]:-1;
            int right=mid+1<=col-1?mat[r][mid+1]:-1;
            if(mat[r][mid]>left && mat[r][mid]>right)
            return new int[]{r,mid};
            else if(mat[r][mid]<left)
            high=mid-1;
            else
            low=mid+1;
        }
        return new int[]{-1,-1};
        
    }
    int maxele(int [][]mat,int col){
        int max=Integer.MIN_VALUE;
        int index=-1;
        for(int i=0;i<mat.length;i++){
            if(mat[i][col]>max){
            max=mat[i][col];
            index=i;
        }
        }
    
    return index;
}
}