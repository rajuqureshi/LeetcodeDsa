class Solution {
    public int Ways(int i,int[]arr,int trt,int sum,int res,int[][]dp){
        if(i==arr.length){
            if(res==trt) return 1;
            else return 0;
        }
        if(dp[i][res+sum]!=-1) return dp[i][res+sum];
        int add = Ways(i+1,arr,trt,sum,res+arr[i],dp);
        int sub = Ways(i+1,arr,trt,sum,res-arr[i],dp);
        return dp[i][res+sum] = add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        int n= nums.length;
        for(int ele : nums) sum+=ele;
        int[][] dp = new int[n][2*sum+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        return Ways(0,nums,target,sum,0,dp);
    }
}