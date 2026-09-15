class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.containsKey(nums[i]) ? hashMap.get(nums[i]) + 1 : 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.getValue(), a.getValue()));

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            pq.offer(entry);
        }

        int[] result = new int[k];

        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            result[i] = pq.poll().getKey();
        }

        return result;
    }

}