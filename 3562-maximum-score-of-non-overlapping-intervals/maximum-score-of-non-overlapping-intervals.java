import java.util.*;

class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        
        // Step 1: Augment the intervals with their original index
        // arr[i] = [start, end, weight, original_index]
        int[][] arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i; 
        }
        
        // Step 2: Sort intervals by end time
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));
        
        // DP Tables
        // dpWeight[i][k] = max weight using up to k intervals from the first i elements
        // dpIndices[i][k] = the lexicographically smallest indices to get that weight
        long[][] dpWeight = new long[n + 1][5];
        List<Integer>[][] dpIndices = new ArrayList[n + 1][5];
        
        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dpIndices[i][k] = new ArrayList<>(4);
            }
        }
        
        // Step 3: Populate the DP table
        for (int i = 1; i <= n; i++) {
            int start = arr[i-1][0];
            long weight = arr[i-1][2];
            int origIdx = arr[i-1][3];
            
            // Binary search: find the last interval that ends strictly before the current one starts
            int low = 0, high = i - 2, prev = 0;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[mid][1] < start) {
                    prev = mid + 1; // +1 because DP array is 1-indexed
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            
            for (int k = 1; k <= 4; k++) {
                // Option 1: Skip the current interval
                long wSkip = dpWeight[i-1][k];
                List<Integer> idxSkip = dpIndices[i-1][k];
                
                // Option 2: Take the current interval
                long wTake = dpWeight[prev][k-1] + weight;
                List<Integer> idxTake = new ArrayList<>(dpIndices[prev][k-1]);
                idxTake.add(origIdx);
                Collections.sort(idxTake); // Ensure the list remains sorted for comparison
                
                // Compare and store the better choice
                if (isBetter(wTake, idxTake, wSkip, idxSkip)) {
                    dpWeight[i][k] = wTake;
                    dpIndices[i][k] = idxTake;
                } else {
                    dpWeight[i][k] = wSkip;
                    dpIndices[i][k] = idxSkip;
                }
            }
        }
        
        // Step 4: Extract the absolute best result across k = 1, 2, 3, 4
        long maxW = -1;
        List<Integer> bestIdx = new ArrayList<>();
        for (int k = 1; k <= 4; k++) {
            if (isBetter(dpWeight[n][k], dpIndices[n][k], maxW, bestIdx)) {
                maxW = dpWeight[n][k];
                bestIdx = dpIndices[n][k];
            }
        }
        
        // Convert to int[] format
        int[] res = new int[bestIdx.size()];
        for (int i = 0; i < bestIdx.size(); i++) {
            res[i] = bestIdx.get(i);
        }
        return res;
    }
    
    // Helper function to decide which configuration is strictly "better"
    private boolean isBetter(long w1, List<Integer> idx1, long w2, List<Integer> idx2) {
        if (w1 != w2) {
            return w1 > w2; // Higher weight is always better
        }
        // If weights are equal, find the lexicographically smaller list
        for (int i = 0; i < Math.min(idx1.size(), idx2.size()); i++) {
            int c1 = idx1.get(i);
            int c2 = idx2.get(i);
            if (c1 != c2) {
                return c1 < c2;
            }
        }
        // If one is a strict prefix of the other, the shorter one is smaller
        return idx1.size() < idx2.size();
    }
}