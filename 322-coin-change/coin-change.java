class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, -1);

        int result = minChange(coins, amount, dp);
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }

    public int minChange(int[] coins, int amount, int[] dp) {

        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[amount] != -1) {
            return dp[amount];
        }

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int result = minChange(coins, amount - coin, dp);

            if (result != Integer.MAX_VALUE) {
                int candidate = 1 + result;
                min = Math.min(min, candidate);
            }
        }

        dp[amount] = min;

        return dp[amount];
    }
}