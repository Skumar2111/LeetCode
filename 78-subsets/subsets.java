class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        generateSubsets(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void generateSubsets(
            int[] nums,
            int index,
            List<Integer> current,
            List<List<Integer>> result) {

        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Include nums[index]
        current.add(nums[index]);
        generateSubsets(nums, index + 1, current, result);

        // Backtrack
        current.remove(current.size() - 1);

        // Exclude nums[index]
        generateSubsets(nums, index + 1, current, result);
    }
}