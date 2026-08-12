class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxOnes = -1;
        int bestRow = 0;
        for (int i = 0; i < mat.length; i++) {
            int[] sortedRow = mat[i].clone(); 
            Arrays.sort(sortedRow);           
            int lb = lowerBound(sortedRow);
            int count = sortedRow.length - lb;
            if (count > maxOnes) {
                maxOnes = count;
                bestRow = i;
            }
        }
        return new int[]{bestRow, maxOnes};
    }
    private int lowerBound(int[] row) {
        int lo = 0, hi = row.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (row[mid] < 1) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}