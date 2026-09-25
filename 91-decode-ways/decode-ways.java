
class Solution {
    public int numDecodings(String s) {

        int[] dp = new int[s.length() + 1];

        Arrays.fill(dp, -1);
        return decodings(s, 0, dp);
    }

    public int decodings(String s, int index, int[] dp) {

        // Successfully consumed the entire string
        if (index == s.length()) {
            return 1;
        }

        // A single 0 cannot be decoded
        if (s.charAt(index) == '0') {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        // Take one digit
        int ways = decodings(s, index + 1,dp);

        // Take two digits if they form 10 to 26
        if (index + 1 < s.length()) {

            int num = (s.charAt(index) - '0') * 10
                    + (s.charAt(index + 1) - '0');

            if (num >= 10 && num <= 26) {
                ways += decodings(s, index + 2,dp);
            }
        }

        dp[index] = ways;

        return ways;
    }
}
