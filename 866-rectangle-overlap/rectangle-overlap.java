class Solution {
    public boolean isRectangleOverlap(int[] arr1, int[] arr2) {
        int left  = Math.max(arr1[0],arr2[0]);
        int right  = Math.min(arr1[2],arr2[2]);

        int bottom = Math.max(arr1[1],arr2[1]);
        int top = Math.min(arr1[3],arr2[3]);
        
        return left<right && bottom<top;
    }
}