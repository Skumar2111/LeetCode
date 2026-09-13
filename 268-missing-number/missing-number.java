class Solution {
    public int missingNumber(int[] nums) {
        
        int sum = ((nums.length) * (nums.length + 1)) / 2;
        int actual = 0;

        for(int i = 0 ; i < nums.length ; i++)
        {
            actual = actual + nums[i];
        }

        return sum - actual;

    }
}