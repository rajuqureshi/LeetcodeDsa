import java.util.*;

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        Map<String, Integer> map = new HashMap<>();
        int maxOverlap = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (img1[i][j] == 1) {

                    for (int i1 = 0; i1 < n; i1++) {
                        for (int j1= 0; j1 < n; j1++) {

                            if (img2[i1][j1] == 1) {

                                int rowShift = i1 - i;
                                int colShift = j1 - j;

                                String key = rowShift + "," + colShift;

                                map.put(key, map.getOrDefault(key, 0) + 1);

                                maxOverlap = Math.max(maxOverlap,map.get(key));
                            }
                        }
                    }
                }
            }
        }

        return maxOverlap;
    }
}