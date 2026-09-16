class Solution {
    public int majorityElement(int[] nums) {
        
        int count = 0;
        int element = nums[0];


        for(int i = 0 ; i < nums.length ; i++)
        {
            if(count == 0)
            {
                element = nums[i];
                count++;
            }
            else if(nums[i] == element)
            {
                count++;
            }
            else
            {
                count--;
            }
        }


        int result = 0;

        for(int i = 0 ; i < nums.length ; i++)
        {
            if(nums[i] == element)
            {
                result++;
            }
        }


        if(result > nums.length / 2)
        {
            return element;
        }
       return -1;
}
}
