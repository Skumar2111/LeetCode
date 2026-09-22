class Solution {
    public int longestCommonSubsequence(String text1, String text2) {


        int[][] memo = new int[text1.length() + 1][text2.length() + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

       return longestCommonSub(text1, text2, text1.length(), text2.length(),memo);

    }

    public int longestCommonSub(String input1, String input2, int m, int n , int[][] memo) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if(memo[m][n] != -1) return memo[m][n];

        if (input1.charAt(m - 1) == input2.charAt(n - 1)) {
            memo[m][n] =  1 + longestCommonSub(input1, input2, m - 1, n - 1,memo);
            return memo[m][n];
        }

        else {
            memo[m][n] = Math.max(longestCommonSub(input1, input2, m - 1, n, memo), longestCommonSub(input1, input2, m, n - 1, memo));
            return memo[m][n];
        }
    }
}