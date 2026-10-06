class Solution {
    public int lps(int i,int j,StringBuilder s1,StringBuilder s2,int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j] = 1+lps(i-1,j-1,s1,s2,dp); 
        else return dp[i][j] = Math.max(lps(i-1,j,s1,s2,dp),lps(i,j-1,s1,s2,dp));
    }
    public int lcs(String a,String b){
        StringBuilder t1 = new StringBuilder(a);
        StringBuilder t2 = new StringBuilder(b);
        int m = t1.length();
        int n = t2.length();
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return lps(m-1,n-1,t1,t2,dp);
    }
    public String reverse(String s){
        StringBuilder str = new StringBuilder(s);
        return str.reverse().toString();
    }
    public int longestPalindromeSubseq(String s) {
        return lcs(s,reverse(s));
    }
    public int minInsertions(String s) {
        return s.length() -longestPalindromeSubseq(s);
    }
}