class Solution {
    public int search(int[] arr, int key) {
        // code here
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(arr[mid]==key) return mid;
            else if(arr[mid]>=arr[low]){
                if(arr[low]<=key && key<arr[mid]) high = mid-1;
                else low= mid+1;
            }else{
                if(arr[mid]<key && key<=arr[high]) low=mid+1;
                else high = mid-1;
            }
        }
        return -1;
    }
}