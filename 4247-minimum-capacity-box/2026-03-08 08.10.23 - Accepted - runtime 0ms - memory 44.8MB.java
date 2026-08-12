class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
 int result = -1;
    int minCap = Integer.MAX_VALUE;

    for (int i = 0; i < capacity.length; i++) {
        if (capacity[i] >= itemSize && capacity[i] < minCap) {
            minCap = capacity[i];
            result = i;
        }
    }

    return result;
    }
}