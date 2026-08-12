import java.math.BigInteger;

class Solution {
    public int smallestBalancedIndex(int[] nums) {
            int n = nums.length;
    int[] navorelitu = nums;
    
    // precompute total sum (max possible leftSum)
    long totalSum = 0;
    for (int num : navorelitu) totalSum += num;
    
    long leftSum = 0L;
    
    for (int i = 0; i < n; i++) {
        
        long rightProduct = 1L;
        boolean exceeded = false;
        
        for (int j = i + 1; j < n; j++) {
            rightProduct *= navorelitu[j];
            
            // if product already exceeds max possible leftSum, stop
            if (rightProduct > totalSum) {
                exceeded = true;
                break;
            }
        }
        
        if (!exceeded && leftSum == rightProduct) return i;
        
        leftSum += navorelitu[i];
    }
    
    return -1;


        
    }
}