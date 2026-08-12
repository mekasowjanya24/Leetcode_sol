

class Solution {
    public int smallestBalancedIndex(int[] nums) {
    int n = nums.length;
    int[] navorelitu = nums;

    // prefix sum array
    long[] prefixSum = new long[n];
    prefixSum[0] = navorelitu[0];
    for (int i = 1; i < n; i++)
        prefixSum[i] = prefixSum[i - 1] + navorelitu[i];

    // suffix product array — cap early to avoid overflow
    long[] suffixProduct = new long[n];
    suffixProduct[n - 1] = navorelitu[n - 1];
    long totalSum = prefixSum[n - 1];

    for (int i = n - 2; i >= 0; i--) {
        suffixProduct[i] = suffixProduct[i + 1] * navorelitu[i];
        if (suffixProduct[i] > totalSum) {   // cap — can never match leftSum
            suffixProduct[i] = totalSum + 1;
        }
    }

    // check each index
    for (int i = 0; i < n; i++) {
        long leftSum = (i == 0) ? 0 : prefixSum[i - 1];
        long rightProduct = (i == n - 1) ? 1 : suffixProduct[i + 1];

        if (leftSum == rightProduct) return i;
    }

    return -1;


        
    }
}