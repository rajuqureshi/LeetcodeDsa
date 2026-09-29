class Solution {
    public int houseRob(int[] arr,int i,int[] dp){
        if(i>=arr.length) return 0;
        if(dp[i]!=-1) return dp[i];
        return dp[i] = Math.max(houseRob(arr,i+1,dp),(arr[i]+houseRob(arr,i+2,dp)));
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return houseRob(nums,0,dp);
    }
}