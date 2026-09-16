class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int longest = 1;
        int n = nums.length;

        if(n == 0) return 0;

        for(int i = 0 ; i < nums.length ; i++)
        {
            hashSet.add(nums[i]);
        }


        for(Integer it : hashSet)
        {
            
            if(!hashSet.contains(it - 1))
            {
                int count = 1;
                int x = it;
                while(hashSet.contains(x + 1))
                {
                    x = x + 1;
                   count = count + 1;
                }

                longest = Math.max(count,longest);
            }

        }

        return longest;
      
    }
}