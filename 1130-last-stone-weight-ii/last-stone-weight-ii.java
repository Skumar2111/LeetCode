class Solution {
    public int lastStoneWeightII(int[] stones) {

        int totalSum = 0;

        for (int stone : stones) {
            totalSum += stone;
        }

        int target = totalSum / 2;

        // dp[sum] = can we create this sum?
        boolean[] dp = new boolean[target + 1];

        // We can always create sum 0 by taking nothing
        dp[0] = true;

        for (int stone : stones) {

            // Go backwards so each stone is used only once
            for (int sum = target; sum >= stone; sum--) {

                // Skip OR Take
                dp[sum] = dp[sum] || dp[sum - stone];
            }
        }

        // Find the largest achievable subset sum <= target
        int best = 0;

        for (int sum = target; sum >= 0; sum--) {
            if (dp[sum]) {
                best = sum;
                break;
            }
        }

        // Difference between the two groups
        return totalSum - 2 * best;
    }
}