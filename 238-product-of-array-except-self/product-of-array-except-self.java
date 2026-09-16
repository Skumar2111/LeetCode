class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        int[] result = new int[nums.length];

        int n = nums.length;

        int leftProduct=1;
        int rightProduct=1;

        left[0] = 1;
        right[n-1] = 1;

        for(int i = 1 ; i < nums.length ; i++)
        {
            left[i] = left[i-1] * nums[i-1];
        }

        for(int j = n-2 ; j >= 0 ; j--)
        {
            right[j] = right[j+1] * nums[j+1];
        }

        for(int i = 0 ; i < n ; i++)
        {
            result[i] = left[i] * right[i];
         }

return result;

    }
}