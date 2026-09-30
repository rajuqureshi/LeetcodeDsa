class Solution {
    public int help(int[][]dp,int m,int n){
        if(m==1) return 1;
        if(n==1)return 1;
        if(m==0 || n==0) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        return dp[m][n] = help(dp,m-1,n) + help(dp,m,n-1);

    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int[] i : dp ){
            Arrays.fill(i,-1);
        }
        return help(dp,m,n);
    }
}