class Solution {
    public int smallestBalancedIndex(int[] nums){
    int n = nums.length;
        
    int[] navorelitu = nums;
    
    long leftSum = 0L;  // ← long too!
    
    for (int i = 0; i < n; i++) {
        
        long rightProduct = 1L;
        for (int j = i + 1; j < n; j++) {
            rightProduct *= navorelitu[j];
            if (rightProduct > 1_000_000_000_000L) {  // ← cap at safe threshold
                rightProduct = Long.MAX_VALUE;
                break;
            }
        }
        
        if (leftSum == rightProduct) return i;
        
        leftSum += navorelitu[i];  // ← now accumulates in long safely
    
    }
    return -1;
}
    }