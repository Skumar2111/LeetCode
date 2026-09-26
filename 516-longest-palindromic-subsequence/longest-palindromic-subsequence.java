class Solution {
    public int longestPalindromeSubseq(String s) {

        int[][] dp = new int[s.length()+1][s.length()+1];

        for(int i = 0 ; i < s.length() ; i++)
        {
            Arrays.fill(dp[i],-1);
        }
    
        int low = 0;
        int high = s.length()-1;
        return palindromicSubseq(s,low , high, dp);    
    }


    public int palindromicSubseq(String s , int low , int high, int[][] dp)
    {
        if(low > high)
        {
            return 0;
        }

        if(low == high)
        {
            return 1;
        }


        if(dp[low][high] != -1)
        {
            return dp[low][high];
        }

        if(s.charAt(low) == s.charAt(high))
        {
           return dp[low][high] =  2 + palindromicSubseq(s,low+1,high-1,dp);
        }

        return dp[low][high] =  Math.max(palindromicSubseq(s,low+1,high,dp), palindromicSubseq(s,low,high-1,dp));


       
    }
}