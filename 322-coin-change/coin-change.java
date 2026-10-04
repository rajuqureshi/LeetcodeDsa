class Solution {
    public long countCoins(int i,int[] arr,int amt,long[][] dp){
        if(i==arr.length){
            if(amt==0) return 0;
            else return Integer.MAX_VALUE;
        }
        if(dp[i][amt]!=-1) return dp[i][amt];
        long skip = countCoins(i+1,arr,amt,dp);
        if(amt-arr[i]<0) return dp[i][amt] = skip;
        long pick = 1+ countCoins(i,arr,amt-arr[i],dp);
        return dp[i][amt] = Math.min(pick,skip);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        long[][] dp = new long[n][amount+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        int ans = (int)countCoins(0,coins,amount,dp);
        if(ans==Integer.MAX_VALUE) return -1;
        else return ans;
    }
}