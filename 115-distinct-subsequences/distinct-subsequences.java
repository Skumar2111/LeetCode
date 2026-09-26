class Solution {
    public int numDistinct(String s, String t) {


        int[][] dp = new int[s.length()][t.length()];

        for(int i = 0 ; i < s.length() ; i++)
        {
            Arrays.fill(dp[i],-1);
        }

        return distinctSubsequence(s, t, 0, 0, dp);

    }

    public int distinctSubsequence(String source , String target , int indexSource , int indexTarget, int[][] dp)
    {

        if(indexTarget == target.length())
        {
            return 1;
        }

        if(indexSource == source.length())
        {
            return 0;
        }

        if(dp[indexSource][indexTarget] != -1)
        {
            return dp[indexSource][indexTarget];
        }

        // string matched
        if(source.charAt(indexSource) == target.charAt(indexTarget))
        {
          return dp[indexSource][indexTarget] =  distinctSubsequence(source,target,indexSource+1,indexTarget+1,dp) + 
          distinctSubsequence(source,target,indexSource+1,indexTarget,dp);
        }
        else
        {
            return dp[indexSource][indexTarget] =  distinctSubsequence(source,target,indexSource+1,indexTarget,dp);
        }

    }
}