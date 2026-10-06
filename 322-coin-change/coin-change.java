class Solution {
    public long countCoins(int i,int[] arr,int amt,long[][] dp){
        if(i==-1){
            if(amt==0) return 0;
            else return Integer.MAX_VALUE;
        }
        if(dp[i][amt]!=-1) return dp[i][amt];
        long skip = countCoins(i-1,arr,amt,dp);
        if(amt-arr[i]<0) return dp[i][amt] = skip;
        else{long pick = 1+ countCoins(i,arr,amt-arr[i],dp);
            return dp[i][amt] = Math.min(pick,skip);
        }
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        long[][] dp = new long[n][amount+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                long skip = (i>0) ? dp[i-1][j] : (j==0) ? 0 : Integer.MAX_VALUE;
                if(j-coins[i]<0)  dp[i][j] = skip;
                else{
                    long pick = 1+dp[i][j-coins[i]];
                    dp[i][j] = Math.min(pick,skip);
                }
            }
        }
        int ans = (int)dp[n-1][amount];
        if(ans==Integer.MAX_VALUE) return -1;
        else return ans;
    }
}