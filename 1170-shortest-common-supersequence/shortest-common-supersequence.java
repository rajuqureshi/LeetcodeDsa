class Solution {
    public String lcs(String str1,String str2){
        int m = str1.length();
        int n = str2.length();
        int [][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int i=m,j=n;
        StringBuilder ans = new StringBuilder();
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                ans.append(str1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                // ans.append(str1.charAt(i-1));
                i--;
            }else{
                j--;
            } 
        }
       return ans.reverse().toString();
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        String LCSs = lcs(str1,str2);
        System.out.println(LCSs);
        int i=0,j=0,k=0;
        StringBuilder scs = new StringBuilder();
        while(i<str1.length() && j<str2.length() && k<LCSs.length()){
            while(i<str1.length() && str1.charAt(i)!=LCSs.charAt(k)){
                scs.append(str1.charAt(i));
                i++;
            }

            while(j<str2.length() && str2.charAt(j)!=LCSs.charAt(k)){
                scs.append(str2.charAt(j));
                j++;
            }

            scs.append(LCSs.charAt(k));
            i++;j++;k++;
        }

        while(i<str1.length()){
            scs.append(str1.charAt(i));
            i++;
        }

        while(j<str2.length()){
            scs.append(str2.charAt(j));
            j++;
        }
        // for(char c : ans.toCharArray()){
        //     while(str1.charAt(i)!=c){
        //         scs.append(str1.charAt(i));
        //         i++;
        //     }
        //     while(str2.charAt(j)!=c){
        //         scs.append(str2.charAt(j));
        //         j++;
        //     }
        //     scs.append(c);
        //     i++;
        //     j++;
        //     k++;
        // }
        // while(i<str1.length()){
        //     scs.append(str1.charAt(i));
        //     i++;
        // }
        
        // while(j<str2.length()){
        //     scs.append(str2.charAt(j));
        //     j++;
        // }
        return scs.toString();
    }
}