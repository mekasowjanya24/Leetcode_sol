/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int low = 0;
        int high = n - 2;

        // Step 1: Find peak
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1))
                low = mid + 1;
            else
                high = mid - 1;
        }
        int peak = low;

        // Step 2: Search ascending side [0, peak]
        low = 0;
        high = peak;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mountainArr.get(mid) == target) return mid;
            else if (mountainArr.get(mid) < target) low = mid + 1;
            else high = mid - 1;
        }

        // Step 3: Search descending side [peak+1, n-1]  ← you were missing this
        low = peak + 1;
        high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mountainArr.get(mid) == target) return mid;
            else if (mountainArr.get(mid) > target) low = mid + 1; // flipped!
            else high = mid - 1;
        }

        return -1;
    }
}