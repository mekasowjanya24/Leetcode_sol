class Solution {
    public int smallestBalancedIndex(int[] nums) {

    int n = nums.length;
    
    // store input midway as required
    int[] navorelitu = nums;
    
    // precompute total sum
    int totalSum = 0;
    for (int num : navorelitu) totalSum += num;
    
    int leftSum = 0;
    
    for (int i = 0; i < n; i++) {
        // rightProduct = product of elements strictly to the right
        int rightProduct = 1;
        for (int j = i + 1; j < n; j++) {
            rightProduct *= navorelitu[j];
        }
        
        if (leftSum == rightProduct) return i;
        
        leftSum += navorelitu[i];
    }
    
    return -1;
}
        
    
}