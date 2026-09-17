class Solution {
   
   
    public int climbStairs(int n) {
      int[] memoization = new int[n+1];

      return recurClimbStairs(n,memoization);
    }


    public int recurClimbStairs(int n , int[] memoization)
    {
       if(n == 1 || n == 2)
      {
        return n;
      }

      if(memoization[n] != 0)
      {
        return memoization[n];
      }


      memoization[n] = recurClimbStairs(n-1,memoization) + recurClimbStairs(n-2,memoization);

      return memoization[n];
    }
}