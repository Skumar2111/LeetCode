class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] result = {-1,-1};

        HashMap<Integer,Integer> intermeidate_hashMap = new HashMap<>();
        
        for(int i = 0 ; i < nums.length ;i++)
        {
            if(intermeidate_hashMap.containsKey(target - nums[i]))
            {
                result[0] = intermeidate_hashMap.get(target - nums[i]);
                result[1] = i;
                break;
            }
            else
            {
                intermeidate_hashMap.put(nums[i],i);
            }
        }

        return result;
    }
}