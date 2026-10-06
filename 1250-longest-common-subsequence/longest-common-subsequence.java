class Solution {
    static int[][] dp;
    public int  commonSequence(StringBuilder s1,StringBuilder s2,int m,int n){
        if(m<0 || n<0) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        if(s1.charAt(m)==s2.charAt(n)){
            return dp[m][n] = 1+ commonSequence(s1,s2,m-1,n-1);
        } else {
           return dp[m][n] = Math.max(commonSequence(s1,s2,m-1,n),commonSequence(s1,s2,m,n-1));
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
       StringBuilder s1 = new StringBuilder(text1);
       StringBuilder s2 = new StringBuilder(text2);
       int m= s1.length();
       int n=s2.length();
       dp = new int[m][n];
       for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
              dp[i][j] = -1;
            }
       }
       return commonSequence(s1,s2,m-1,n-1);
    }
}