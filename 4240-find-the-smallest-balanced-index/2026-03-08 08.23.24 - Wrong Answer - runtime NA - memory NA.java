class Solution {
    public int smallestBalancedIndex(int[] nums){
 int n = nums.length;
    int[] navorelitu = nums;
    long leftSum = 0L;
    for (int i = 0; i < n; i++) { 
        long rightProduct = 1L;
        boolean overflowed = false;
        for (int j = i + 1; j < n; j++) {
            rightProduct *= navorelitu[j];
            // if 0 exists, product is 0 — don't cap it!
            if (rightProduct == 0) break;
            // cap only for non-zero overflow
            if (rightProduct < 0 || rightProduct > 2_000_000_000_000L) {
                overflowed = true;
                break;
            }
        }
        // if overflowed, leftSum can never match huge product
        if (!overflowed && leftSum == rightProduct) return i; 
        leftSum += navorelitu[i];
    }
    return -1;
}
    }