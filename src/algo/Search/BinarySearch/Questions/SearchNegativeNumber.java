/**
 * @author xuqiluo
 * @date 2024-08-01
 */
package algo.Search.BinarySearch.Questions;

import org.junit.Assert;
import org.junit.Test;

public class SearchNegativeNumber {

    public static int search(int[] nums) {
        if (nums.length == 0) return 0;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= 0) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] < 0) {
            return nums.length - start;
        } else if (nums[end] < 0) {
            return nums.length - end;
        }else {
            return 0;
        }
    }

    @Test
    public void test() {
        // 测试用例 1：数组为空
        int[] testCase1 = {};
        Assert.assertEquals(0, search(testCase1)); // 应输出 0

        // 测试用例 2：没有负数
        int[] testCase2 = {5, 4, 3, 2, 1, 0};
        Assert.assertEquals(0, search(testCase2)); // 应输出 0

        // 测试用例 3：全部是负数
        int[] testCase3 = {-1, -2, -3, -4, -5};
        Assert.assertEquals(5, search(testCase3)); // 应输出 5

        // 测试用例 4：有一些负数和一些非负数
        int[] testCase4 = {3, 2, 1, 0, -1, -2, -3};
        Assert.assertEquals(3, search(testCase4)); // 应输出 3

        // 测试用例 5：只有一个元素（非负数）
        int[] testCase5 = {1};
        Assert.assertEquals(0, search(testCase5)); // 应输出 0

        // 测试用例 6：只有一个元素（负数）
        int[] testCase6 = {-1};
        Assert.assertEquals(1, search(testCase6)); // 应输出 1

        // 测试用例 7：数组包含0和负数
        int[] testCase7 = {0, -1, -2, -3};
        Assert.assertEquals(3, search(testCase7)); // 应输出 3

        // 测试用例 8：数组包含正数、0和负数
        int[] testCase8 = {2, 1, 0, -1, -2};
        Assert.assertEquals(2, search(testCase8)); // 应输出 2
    }
}
