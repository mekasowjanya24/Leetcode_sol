class Solution {
    public boolean canReach(int[] start, int[] target) {
        int sumstart=start[0]+start[1];
        int sumtarget=target[0]+target[1];
        return (sumstart%2)==(sumtarget%2);
        
    }
}