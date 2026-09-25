class Solution {
    public int lengthOfLIS(int[] nums) {

        int index = 0;
        int prev = -1;

        int[][] dp = new int[nums.length][nums.length+1];

        for(int i = 0 ; i < nums.length ; i++)
        {
            for(int j = 0 ; j < nums.length + 1 ; j++)
            {
                dp[i][j] = -1;
            }
        }
       
        return LIS(nums, index, prev, dp);
    }

    public int LIS(int[] nums, int index, int prev, int[][] dp) {
        if (index == nums.length) {
            return 0;
        }

        if(dp[index][prev+1] != -1)
        {
            return dp[index][prev+1];
        }

        //NOT TAKE
        int length = 0 + LIS(nums, index + 1, prev,dp);

        //TAKE
        if (prev == -1 || nums[index] > nums[prev]) {
            length = Math.max(length, 1 + LIS(nums, index + 1, index,dp));
        }

        dp[index][prev+1] = length ;

        return dp[index][prev+1];
    }
}