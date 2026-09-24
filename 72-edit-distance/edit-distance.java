class Solution {
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
       return  calcMinDistance(word1, word2, dp , m , n);
    }

    public int calcMinDistance(String word1, String word2, int[][] dp,int m , int n) {

        if(m == 0)
        {
            return n;
        }

        if(n == 0)
        {
            return m;
        }


        if(dp[m][n] != -1)
        {
            return dp[m][n];
        }


        if(word1.charAt(m-1) == word2.charAt(n-1))
        {
            return dp[m][n] = calcMinDistance(word1,word2,dp,m-1,n-1);
        }

        else
        {
            int insert , delete , replace;

            insert =  calcMinDistance(word1,word2,dp,m,n-1);

            delete =  calcMinDistance(word1,word2,dp,m-1,n);

            replace =  calcMinDistance(word1,word2,dp,m-1,n-1);


             return  dp[m][n] = 1 + Math.min(insert,Math.min(delete,replace));
        }




    }
}