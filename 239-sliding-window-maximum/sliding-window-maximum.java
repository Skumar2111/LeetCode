class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> dQueue = new ArrayDeque<>();

        int n = nums.length;
        for(int i = 0 ; i < k ; i++)
        {
            while(!dQueue.isEmpty() && nums[i] >= nums[dQueue.peekLast()])
            {
                dQueue.pollLast();
            }

            dQueue.addLast(i);
        }

        for(int i = k ; i < nums.length ; i++)
        {
            res.add(nums[dQueue.peekFirst()]);

            while(!dQueue.isEmpty() && dQueue.peekFirst() <= i - k)
            {
                dQueue.pollFirst();
            }
            while(!dQueue.isEmpty() && nums[i] >= nums[dQueue.peekLast()]) {
                dQueue.pollLast();
            }

            dQueue.addLast(i);
        }


        res.add(nums[dQueue.peekFirst()]);



int[] arr = res.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return arr;




    }
}
        

    
