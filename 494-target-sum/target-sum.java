class Solution {
    int totalSum = 0;
    public int findTargetSumWays(int[] nums, int target) {

        

        for (int element : nums) {
            totalSum += element;
        }
        int[][] dp = new int[nums.length][2 * totalSum + 1];

        for(int i = 0 ; i < nums.length ; i++)
        {
            Arrays.fill(dp[i], -1);
        }

        int sum = 0;
        int index = 0;
        return solve(nums, target, sum, index, dp);
    }

    public int solve(int[] nums, int target, int sum, int index, int[][] dp) {

        if (index == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        if(dp[index][sum+totalSum] != -1)
        {
            return dp[index][sum + totalSum];
        }
        return dp[index][sum + totalSum] = solve(nums, target, sum + nums[index], index + 1,dp) + solve(nums, target, sum - nums[index], index + 1,dp);

    }
}