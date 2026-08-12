class Solution {
    public int smallestBalancedIndex(int[] nums){
    int n = nums.length;
    
    int[] navorelitu = nums;
    
    int leftSum = 0;
    
    for (int i = 0; i < n; i++) {
        
        long rightProduct = 1L;  // ← long to prevent overflow
        for (int j = i + 1; j < n; j++) {
            rightProduct *= navorelitu[j];
            if (rightProduct > Integer.MAX_VALUE) {  // ← early exit optimization
                rightProduct = Long.MAX_VALUE;
                break;
            }
        }
        
        if (leftSum == rightProduct) return i;
        
        leftSum += navorelitu[i];
    }
    
    return -1;
}
    }