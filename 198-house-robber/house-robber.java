class Solution {
    public int rob(int[] nums) {

        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp,-1);
       return maxMoney(nums,0, dp);

    }

    public int maxMoney(int[] nums , int i, int[] dp) {
        if (nums.length == 0 || i >= nums.length) {
            return 0;
        }

        if(dp[i] != -1)
        {
            return dp[i];
        }


        dp[i] = Math.max(nums[i]+maxMoney(nums,i+2,dp),(maxMoney(nums,i+1,dp)));

        return dp[i];
    }
}