class Solution {
    public int subSequence(List<Integer> arr,int i,int target,int[][] dp){
        if(i==arr.size()){
            if(target==0) return 0;
            else return -10000;
        }
        if(dp[i][target]!=-1) return dp[i][target];
        int skip = subSequence(arr,i+1,target,dp);
        if(target-arr.get(i)<0) return dp[i][target] = skip;
        
        int pick = -10000;
        if(target-arr.get(i)>=0){
            pick = 1+ subSequence(arr,i+1,target-arr.get(i),dp);
            
        }
        return dp[i][target] = Math.max(skip,pick);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[][] dp = new int[n][target+1];
        for(int[] num : dp) Arrays.fill(num,-1);
        int ans = subSequence(nums,0,target,dp);
        return ans>0 ? ans : -1;
    }
}