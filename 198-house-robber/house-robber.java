class Solution {
    int[] dp;
    public int help(int[] arr,int i){
        if(i<0) return 0;
        if(dp[i]>=0) return dp[i];
        int result = Math.max(help(arr,i-2)+ arr[i] ,help(arr,i-1));
        dp[i] = result;
        return result;
    }
    public int rob(int[] nums) {
        dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return help(nums,nums.length-1);
    }
}