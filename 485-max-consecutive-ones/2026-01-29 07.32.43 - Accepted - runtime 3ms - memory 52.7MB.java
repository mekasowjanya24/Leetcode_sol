class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max_1 = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                max_1 = Math.max(max_1, count);
            } else {
                count = 0;
            }
        }
        return max_1;
    }
}
