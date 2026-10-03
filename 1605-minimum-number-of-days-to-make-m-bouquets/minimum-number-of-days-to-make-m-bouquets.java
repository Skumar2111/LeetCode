class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        long requiredFlowers = (long) m * k;

        if (requiredFlowers > bloomDay.length) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            min = Math.min(min, day);
            max = Math.max(max, day);
        }

        while (min <= max) {

            int mid = min + (max - min) / 2;

            if (isPossible(bloomDay, m, k, mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }

    private boolean isPossible(int[] bloomDay, int m, int k, int day) {

        int consecutive = 0;
        int bouquets = 0;

        for (int bloom : bloomDay) {

            if (bloom <= day) {
                consecutive++;

                if (consecutive == k) {
                    bouquets++;
                    consecutive = 0;

                    if (bouquets == m) {
                        return true;
                    }
                }

            } else {
                consecutive = 0;
            }
        }

        return false;
    }
}