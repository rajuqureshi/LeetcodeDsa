class Solution {
    public int commonSequence(StringBuilder s1,StringBuilder s2,int i,int j,int[][]dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] =  1+commonSequence(s1,s2,i-1,j-1,dp);
        }else{
            return dp[i][j] = Math.max(commonSequence(s1,s2,i-1,j,dp),commonSequence(s1,s2,i,j-1,dp));
        }
    }
    public int longestSubSequence(String s1,String s2){
        StringBuilder sb1 = new StringBuilder(s1);
        StringBuilder sb2 = new StringBuilder(s2);
        int m = sb1.length();
        int n = sb2.length();
        int[][] dp = new int[m][n];
        for(int[] num : dp){
            Arrays.fill(num,-1);
        }
        return commonSequence(sb1,sb2,m-1,n-1,dp);
    }
    public String reverseString(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    public int longestPalindromeSubseq(String s) {
        return longestSubSequence(s,reverseString(s));
    }
}