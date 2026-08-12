import java.util.*;
class Solution {
    public int minimumOR(int[][] grid) {
        
        List<List<Integer>> candidates = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> list = new ArrayList<>();
            for (int v : row) list.add(v);
            candidates.add(list);
        }
        
        int result = 0;
        
        for (int bit = 29; bit >= 0; bit--) {
            boolean canAvoid = true;
            List<List<Integer>> newCandidates = new ArrayList<>();
            
            for (List<Integer> row : candidates) {
                List<Integer> filtered = new ArrayList<>();
                for (int val : row) {
                    if ((val & (1 << bit)) == 0) {
                        filtered.add(val);
                    }
                }
                if (filtered.isEmpty()) {
                    canAvoid = false;
                    break;
                }
                newCandidates.add(filtered);
            }
            
            if (canAvoid) {
                candidates = newCandidates;
            } else {
                result |= (1 << bit);
            }
        }
        
        return result;
    }
}
                
                
       
    