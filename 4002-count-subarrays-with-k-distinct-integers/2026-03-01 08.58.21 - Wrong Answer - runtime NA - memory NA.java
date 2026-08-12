class Solution {
    public long countSubarrays(int[] nums, int k, int m) {
        int n = nums.length;
        long result = 0;
        // p1: leftmost left where dist==k AND qual==k (shrink when dist>k OR qual<k)
        // p2: leftmost left where dist==k (shrink when dist>k)
        // valid lefts for right r = [p1, p2_rightbound]
        // p2_rightbound = rightmost l where dist([l,r])==k
        //               = (leftmost l where dist([l,r])<k) - 1
        // Use p2 to find leftmost where dist<k after one more shrink? No...
        
        // CORRECT: use p2 to track leftmost where dist<=k-1 would occur
        // i.e., p2 shrinks while dist >= k (one step beyond)
        
        Map<Integer,Integer> f1 = new HashMap<>(), f2 = new HashMap<>();
        int p1=0, p2=0, d1=0, q1=0, d2=0, q2=0;
        
        for (int r = 0; r < n; r++) {
            // expand f1
            f1.merge(nums[r],1,Integer::sum);
            if(f1.get(nums[r])==1) d1++;
            if(f1.get(nums[r])==m) q1++;
            // expand f2
            f2.merge(nums[r],1,Integer::sum);
            if(f2.get(nums[r])==1) d2++;
            if(f2.get(nums[r])==m) q2++;
            
            // p1: shrink while NOT fully valid
            while(d1 > k || (d1==k && q1 < k)) {
                int nf = f1.merge(nums[p1],-1,Integer::sum);
                if(nf==0){d1--;f1.remove(nums[p1]);}
                else if(nf==m-1) q1--;
                p1++;
            }
            
            // p2: shrink while dist > k-1 (i.e., while dist >= k, keep shrinking)
            // → p2 = leftmost left where dist < k
            // So [p2-1] is the rightmost valid left w.r.t. dist==k
            while(d2 >= k) {
                int nf = f2.merge(nums[p2],-1,Integer::sum);
                if(nf==0){d2--;f2.remove(nums[p2]);}
                else if(nf==m-1) q2--;
                p2++;
            }
            // now [p2, r] has dist < k
            // so rightmost left with dist==k is p2-1
            // valid lefts = [p1, p2-1], count = p2 - p1
            
            result += p2 - p1;
        }
        return result;
    }
}