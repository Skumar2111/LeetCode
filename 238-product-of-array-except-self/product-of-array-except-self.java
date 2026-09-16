class Solution {
    public int[] productExceptSelf(int[] nums) {
       
        int[] right = new int[nums.length];

        int[] result = new int[nums.length];

        int n = nums.length;

        int leftProduct=1;
        int rightProduct=1;

        result[0] = 1;
        right[n-1] = 1;

        for(int i = 1 ; i < nums.length ; i++)
        {
            result[i] = result[i-1] * nums[i-1];
           
        }

        for(int j = n-2 ; j >= 0 ; j--)
        {
            right[j] = right[j+1] * nums[j+1];
        }

        for(int i = 0 ; i < n ; i++)
        {
            result[i] = result[i] * right[i];
         }

return result;

    }
}