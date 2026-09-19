class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();


        permute(nums, result , 0 , new ArrayList<Integer>());

        return result;

    }


    public void permute(int[] nums , List<List<Integer>> result , int  index , ArrayList<Integer> current)
    {

        if(index == nums.length)
        {
            result.add(new ArrayList<>(current));
            return;
        }



        Set<Integer> used = new HashSet<>();

        for(int i = index ; i < nums.length ; i++)
        {


            if(used.contains(nums[i]))
            {
                continue;
            }

            used.add(nums[i]);



            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;

            current.add(nums[index]);

            permute(nums, result ,index+1 , current);

            current.remove(current.size() - 1);

            int temp1 = nums[index];
            nums[index] = nums[i];
            nums[i] = temp1;

        }


    }
}