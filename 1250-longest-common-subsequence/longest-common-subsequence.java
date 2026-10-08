class Solution {
    public int  commonSequence(StringBuilder s1,StringBuilder s2,int m,int n,int[][] dp){
        if(m<0 || n<0) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        if(s1.charAt(m)==s2.charAt(n)){
            return dp[m][n] = 1+ commonSequence(s1,s2,m-1,n-1,dp);
        } else {
           return dp[m][n] = Math.max(commonSequence(s1,s2,m-1,n,dp),commonSequence(s1,s2,m,n-1,dp));
        }
    }
    public int longestCommonSubsequence(String s1, String s2) {
       int m= s1.length();
       int n=s2.length();
       int[][] dp = new int[2][n+1];
       for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                  dp[1][j] = 1+dp[0][j-1];
                } else{
                    dp[1][j] = Math.max(dp[1][j-1],dp[0][j]);
                }
            }

            for(int j=0;j<=n;j++){
                dp[0][j] = dp[1][j];
            }
       }
       return dp[1][n];
    }
}