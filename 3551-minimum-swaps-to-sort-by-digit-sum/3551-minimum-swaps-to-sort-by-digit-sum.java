class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (num > 0) {
                sum[i] += num % 10;
                num /= 10;
            }
            map.put(nums[i], i);
        }

        int[] sorted = nums.clone();

        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = nums[i];
        }

        Arrays.sort(order, (a, b) -> {
            int sa = 0, sb = 0;
            int x = a, y = b;

            while (x > 0) {
                sa += x % 10;
                x /= 10;
            }

            while (y > 0) {
                sb += y % 10;
                y /= 10;
            }

            if (sa != sb) return sa - sb;
            return a - b;
        });

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (sorted[i] == order[i]) continue;

            int j = map.get(order[i]);

            map.put(sorted[i], j);
            map.put(order[i], i);

            int temp = sorted[i];
            sorted[i] = sorted[j];
            sorted[j] = temp;

            count++;
        }

        return count;
    }
}
