class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            int carry = nums[i];
            int sum = 0;
            while(carry>0){
                sum+=carry%10;
                carry/=10;
            }
            if(sum==i) return i;
        }
        return -1;
    }
}