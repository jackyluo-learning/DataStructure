package algo.Search.BinarySearch;

import java.util.Arrays;

/**
 * 递归式查找target
 */
public class FindAnyPositionRecurrent implements BinarySearchStrategy{
    @Override
    public int findPosition(int[] nums, int target) {
        return binarySearchRecurrent(nums, 0, nums.length-1, target);
    }

    private int binarySearchRecurrent(int[] arr, int start, int end, int target) {
        if (arr[start] == target) return start;
        if (arr[end] == target) return end;
        if (start + 1 >= end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (target == arr[mid]) return mid;
        else if (target < arr[mid]) {
            return binarySearchRecurrent(arr, start, mid, target);
        }
        else{
            return binarySearchRecurrent(arr, mid, end, target);
        }
    }
}
