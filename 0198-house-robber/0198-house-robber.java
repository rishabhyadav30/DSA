class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=nums[0];

        for(int i=2; i<=n; i++){
            int take= dp[i-1];
            int skip=  nums[i-1]+dp[i-2];

            dp[i]= Math.max(take,skip);
        }

        return dp[n];
    }
}