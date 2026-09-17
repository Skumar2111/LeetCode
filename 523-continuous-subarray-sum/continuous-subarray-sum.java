class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> prefix = new HashMap<>();

        if (nums.length < 2) {
            return false;
        }

        prefix.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if (prefix.containsKey(sum % k) && (i - prefix.get(sum % k)) >= 2) {
                return true;
            }

            if (!prefix.containsKey(sum % k)) {
                prefix.put(sum % k, i);
            }
            

        }

        return false;
    }
}