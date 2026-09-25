class Solution {
    public int help(int[] cost,int i,int[] dp){
        if(i==0 || i==1) return cost[i];
        if(dp[i]!=-1) return dp[i];
        return dp[i] = cost[i] + Math.min(help(cost,i-1,dp),help(cost,i-2,dp));
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return Math.min(help(cost,n-1,dp),help(cost,n-2,dp));
    }
}