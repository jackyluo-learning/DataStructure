/**
 * @author xuqiluo
 * @date 2024-07-08
 */
package algo.AmazonOA;

import java.util.Deque;
import java.util.LinkedList;

public class AmazonWarehouse {

    /*
    Amazon warehouse has a group of n items of various weights lined up in a row.
    A segment of contiguously placed items can be shipped together if and only if the difference between the weights of the heaviest and lightest item differs by at most k to avoid load imbalance.
    Given the weights of the n items and an integer k, find the number of segments of items that can be shipped together.
    Note: A segment (I, r) is a subarray starting at index /and ending at index where / ≤ r.
    Example
        k = 3
        weights = [1, 3, 6]
        Weight difference between max and min for each (I, r) index pair are:
            • (0, 0) -> max(weights[0]) - min(weights[0]) = max(1) - min(1) = 1 - 1 = 0
            • (0, 1)-> max(1, 3) - min(1, 3) = 3 - 1 = 2
            • (0, 2) -> max(1, 3, 6) - min(1, 3, 6) = 6 - 1 = 5 *** difference > k ***
            • (1, 1) as max(3) - min(3) = 3 - 3 = 0
            • (1, 2) as max(3, 6) - min(3, 6) = 6 - 3 = 3
            • (2,2) as max(6) - min(6) = 6 - 6 = 0
        5 of the 6 possible segments have a difference less than or equal to 3. Return 5.
     */
    public static int countValidSegments(int[] weights, int k) {
        int n = weights.length;
        if (n == 0) {
            return 0;
        }

        int count = 0;
        int left = 0;

        // 使用双端队列维护最大值和最小值
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        for (int right = 0; right < n; right++) {
            // 更新最大值双端队列
            while (!maxDeque.isEmpty() && weights[maxDeque.peekLast()] <= weights[right]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);

            // 更新最小值双端队列
            while (!minDeque.isEmpty() && weights[minDeque.peekLast()] >= weights[right]) {
                minDeque.pollLast();
            }
            minDeque.addLast(right);

            // 检查当前窗口是否满足条件
            while (!maxDeque.isEmpty() && !minDeque.isEmpty() &&
                    weights[maxDeque.peekFirst()] - weights[minDeque.peekFirst()] > k) {
                left++;
                if (maxDeque.peekFirst() < left) {
                    maxDeque.pollFirst();
                }
                if (!minDeque.isEmpty() && minDeque.peekFirst() < left) {
                    minDeque.pollFirst();
                }
            }

            // 计算符合条件的子数组数量
            count += (right - left + 1);
        }

        return count;
    }
}
