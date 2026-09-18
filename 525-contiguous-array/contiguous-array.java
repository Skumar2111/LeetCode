class Solution {
    public int findMaxLength(int[] nums) {
        
        HashMap<Integer,Integer> prefixMap = new HashMap<>();

        prefixMap.put(0,-1);

        int sum = 0;
        int maxLength = 0;

        for(int i = 0 ; i < nums.length ; i++)
        {
            if(nums[i] == 0)
            {
                sum --;
            }
            else
            {
                sum ++;
            }

            if(prefixMap.containsKey(sum))
            {
                int length = i - prefixMap.get(sum);
                maxLength = Math.max(maxLength , length);
            }
            else
            {
                prefixMap.put(sum,i);
            }
        }


        return maxLength;

    }
}