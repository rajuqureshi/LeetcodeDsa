class Solution {
    public boolean subset(int[] arr,int i,int target,int[][] dp){
        if(i==arr.length){
            if(target==0) return true;
            else return false;
        }
        if(dp[i][target]!=-1) return (dp[i][target]==1);
        boolean ans = false;
        boolean skip = subset(arr,i+1,target,dp);
        if(target-arr[i]<0) return ans = skip;
        else{
            boolean pick = subset(arr,i+1,target-arr[i],dp);
            ans = skip || pick;
        }

        dp[i][target] = (ans==true) ? 1 : 0;
        return ans;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num : nums){
            sum+=num;
        }
        if(sum%2!=0) return false;
        int target = sum/2;
        int[][] dp =new int[nums.length][target+1];
        for(int[] num : dp){
            Arrays.fill(num,-1);
        }
        return subset(nums,0,target,dp);
    }
}