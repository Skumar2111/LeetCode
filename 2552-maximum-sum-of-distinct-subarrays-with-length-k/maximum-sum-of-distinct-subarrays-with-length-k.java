class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();

        int left = 0;
        long sum = 0;
        long maxSum = 0;

        for (int right = 0; right < nums.length; right++) {

            // Remove duplicates from the left
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            // Add current element
            set.add(nums[right]);
            sum += nums[right];

            // Keep window size at most k
            if (right - left + 1 > k) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            // Only consider windows of exactly k elements
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}