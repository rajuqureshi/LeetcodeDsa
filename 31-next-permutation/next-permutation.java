class Solution {
    public void reverse(int[] arr,int i,int j){
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pIdx = -1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                pIdx = i;
                break;
            }
        }

        if(pIdx==-1){
            reverse(nums,0,n-1);
            return;
        }
        for(int i=n-1;i>pIdx;i--){
            if(nums[i]>nums[pIdx]){
                int temp = nums[i];
                nums[i] = nums[pIdx];
                nums[pIdx] = temp;
                break;
            }
        }
    
        reverse(nums,pIdx+1,n-1);
    }
}