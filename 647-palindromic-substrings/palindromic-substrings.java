class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        int [][] dp = new int[n][n];
        for(int k=0;k<n;k++){
            int i = 0;
            int j=k;
            while(j<n){
                if(i==j){
                    dp[i][j] = 1;
                    count++;
                }else if(s.charAt(i)==s.charAt(j)){
                    if(k==1){
                        dp[i][j] = 1;
                        count++;
                    }else if(dp[i+1][j-1]==1){
                         dp[i][j] = 1;
                         count++;
                    }
                }
                i++;
                j++;
            }
        }
        return count;
    }
}