class Solution {
    public int maxArea(int[] height) {

      int left = 0, right = height.length - 1;
        int res = 0;
       
        while(left < right)
        {
           int maximum_water = Math.min(height[left] , height[right])*(right - left);

           res = Math.max(res, maximum_water);

           if(height[left] < height[right])
           {
            left += 1;
           }
           else
           {
            right -=1;
           }
        }

        return res;

    }
}