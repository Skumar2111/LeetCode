class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0 ;

        for(int stone : stones)
        {
            totalSum += stone;
        }

        int target = (totalSum) / 2;

        boolean dp[][] = new boolean[stones.length+1][target+1];

        dp[0][0] = true;

        for(int i = 1 ; i <= stones.length ; i++)
        {
            int stone = stones[i-1];

            for(int sum = 0 ; sum <= target ; sum++)
            {
                //skip
                dp[i][sum] = dp[i-1][sum];

                if(sum >= stone)
                {
                    dp[i][sum] = dp[i-1][sum] || dp[i-1][sum - stone];
                }
            }
        }

        int best = 0;

        for(int sum = target ; sum >=0 ; sum--)
        {
            if(dp[stones.length][sum])
            {
                best = sum;
                break;
            }
        }

        return totalSum - 2 * best;
    }
}