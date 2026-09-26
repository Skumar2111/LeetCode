class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int target = 0;
        for (int element : nums) {
            sum += element;
        }

        if (sum % 2 != 0) {
            return false;
        } else {
            target = sum / 2;
        }

        int n = nums.length;

        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];

            for (int j = 1; j <=target; j++) {
                //don't take
                dp[i][j] = dp[i - 1][j];

                if (num <= j) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - num];
                }
            }
        }
  return dp[n][target];
    }
}