class Solution {
    public int change(int amount, int[] coins) {
        
        int[][] dp = new int[coins.length + 1][amount+1];

        for(int i = 0 ; i <= coins.length ; i++)
        {
            for(int j = 0 ; j <= amount ; j++)
            {
                dp[i][j] = -1;
            }
        }

        int n = coins.length;

        int ways = countWays(amount , coins,coins.length, dp);

        return ways;


    }


    public int countWays(int amount , int[] coins, int n, int[][] dp)
    {
        if(amount == 0)
        {
            dp[n][amount] = 1;
            return dp[n][amount];
        }

        if(n == 0)
        {
            return 0;
        }

        if(dp[n][amount] != -1)
        {
            return dp[n][amount];
        }

        if(coins[n-1] <= amount)
        {
            return dp[n][amount] = countWays(amount-coins[n-1], coins, n , dp) +
            countWays(amount, coins , n-1 , dp);
        }

        else
        {
            return dp[n][amount] = countWays(amount , coins , n-1 , dp);
        }

    }
}