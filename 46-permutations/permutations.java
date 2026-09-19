class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        permute(nums,0, result , new ArrayList<Integer>());

        return result;
        
    }

    public void permute(int[] nums , int index , List<List<Integer>> result , ArrayList<Integer> arrayList)
    {

        if(index == nums.length)
        {
            result.add(new ArrayList<>(arrayList));
            return;
        }


        for(int i = index ; i < nums.length ; i++)
        {
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;

            arrayList.add(nums[index]);
            permute(nums,index+1,result, arrayList);
            
            arrayList.remove(arrayList.size()-1);
            
            int temp1 = nums[index];
            nums[index] = nums[i];
            nums[i] = temp1;

        }

    }


    
}