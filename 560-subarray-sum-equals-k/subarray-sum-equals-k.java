class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> prefix = new HashMap<>();

        int current_sum = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            current_sum = current_sum + nums[i];

            if (current_sum == k) {
                result++;
            }

            if (prefix.containsKey(current_sum - k)) {
                result += prefix.get(current_sum - k);
            }

            prefix.put(current_sum, prefix.getOrDefault(current_sum, 0) + 1);
        }

        return result;
    }
}