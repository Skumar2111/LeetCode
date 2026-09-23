class Solution {
    public int rob(int[] nums) {
        
        int[] dp1 = new int[nums.length+1];
        int[] dp2 = new int[nums.length+1];

        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);

        if(nums.length == 1)
        {
            return nums[0];
        }


        return Math.max(maxSum(nums,0,nums.length-2,dp1),maxSum(nums,1,nums.length-1,dp2));
    }


    public int maxSum(int[] nums , int start, int end, int[] dp)
    {
        if(nums.length == 0 || start > end)
        {
            return 0;
        }


        if(dp[start] != -1)
        {
            return dp[start];
        }

        dp[start] =  Math.max(nums[start]+maxSum(nums,start+2,end,dp),maxSum(nums,start+1,end,dp));
        return dp[start];

    }
}