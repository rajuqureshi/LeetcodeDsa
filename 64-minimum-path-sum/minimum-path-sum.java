class Solution {
    public int minPathSum(int[][] arr) {
        int m= arr.length;
        int n= arr[0].length;
        int [][] dp = new int [m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) continue;
                else if(i==0) arr[i][j]+=arr[i][j-1];
                else if(j==0) arr[i][j]+=arr[i-1][j];
                else arr[i][j]+= Math.min(arr[i][j-1],arr[i-1][j]);
            }
        }
        return arr[m-1][n-1];
    }
}