import java.util.*;

class Solution {

    public int minimumDifference(int[] nums) {

        int n = nums.length;
        int half = n / 2;

        int totalSum = 0;

        for (int x : nums) {
            totalSum += x;
        }

        // Split array into two halves
        int[] left = new int[half];
        int[] right = new int[half];

        for (int i = 0; i < half; i++) {
            left[i] = nums[i];
            right[i] = nums[i + half];
        }

        // Store subset sums according to
        // number of selected elements
        ArrayList<Integer>[] leftSums =
            new ArrayList[half + 1];

        ArrayList<Integer>[] rightSums =
            new ArrayList[half + 1];

        for (int i = 0; i <= half; i++) {
            leftSums[i] = new ArrayList<>();
            rightSums[i] = new ArrayList<>();
        }

        // Generate subset sums
        generate(left, 0, 0, 0, leftSums);
        generate(right, 0, 0, 0, rightSums);

        // Sort right-side sums
        for (int i = 0; i <= half; i++) {
            Collections.sort(rightSums[i]);
        }

        int answer = Integer.MAX_VALUE;

        /*
         * We need exactly n/2 elements
         * in the first group.
         *
         * If we take 'count' elements from left,
         * we need half-count from right.
         */
        for (int count = 0; count <= half; count++) {

            ArrayList<Integer> A = leftSums[count];
            ArrayList<Integer> B = rightSums[half - count];

            for (int sumA : A) {

                /*
                 * We want:
                 *
                 * sumA + sumB ≈ totalSum / 2
                 *
                 * Therefore:
                 *
                 * sumB ≈ totalSum / 2 - sumA
                 */
                int target = totalSum / 2 - sumA;

                // Binary search
                int index = Collections.binarySearch(B, target);

                if (index < 0) {
                    index = -index - 1;
                }

                // Check element at index
                if (index < B.size()) {

                    int sum1 = sumA + B.get(index);
                    int sum2 = totalSum - sum1;

                    answer = Math.min(
                        answer,
                        Math.abs(sum1 - sum2)
                    );
                }

                // Check element just before index
                if (index > 0) {

                    int sum1 = sumA + B.get(index - 1);
                    int sum2 = totalSum - sum1;

                    answer = Math.min(
                        answer,
                        Math.abs(sum1 - sum2)
                    );
                }
            }
        }

        return answer;
    }

    // Generate all subset sums
    private void generate(
        int[] nums,
        int index,
        int count,
        int sum,
        ArrayList<Integer>[] result
    ) {

        if (index == nums.length) {
            result[count].add(sum);
            return;
        }

        // Don't take current element
        generate(
            nums,
            index + 1,
            count,
            sum,
            result
        );

        // Take current element
        generate(
            nums,
            index + 1,
            count + 1,
            sum + nums[index],
            result
        );
    }
}