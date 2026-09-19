class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

         Arrays.sort(nums);
         subsetDup(nums,list,new ArrayList<Integer>() , 0);

         return list;
        
    }

    public static void subsetDup(int[] nums, List<List<Integer>> result , ArrayList<Integer> current , int index)
    {

        if(index == nums.length)
        {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        subsetDup(nums,result, current, index + 1);

        int index_1 = index+1;

        while(index_1 < nums.length && nums[index] == nums[index_1])
        {
           
            index_1++;
            
        }

         current.remove(current.size() - 1);

        subsetDup(nums,result, current, index_1);

    }
}