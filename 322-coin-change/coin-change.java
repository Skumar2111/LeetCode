class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;

        int[][] dp = new int[n + 1][amount + 1];

        // amount > 0 cannot be formed with 0 coins
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }

        // amount = 0 requires 0 coins
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= amount; j++) {

                // Exclude current coin
                int exclude = dp[i - 1][j];

                // Include current coin
                int include = Integer.MAX_VALUE;

                if (coins[i - 1] <= j &&
                    dp[i][j - coins[i - 1]] != Integer.MAX_VALUE) {

                    include = 1 + dp[i][j - coins[i - 1]];
                }

                dp[i][j] = Math.min(include, exclude);
            }
        }

        return dp[n][amount] == Integer.MAX_VALUE
                ? -1
                : dp[n][amount];
    }
}