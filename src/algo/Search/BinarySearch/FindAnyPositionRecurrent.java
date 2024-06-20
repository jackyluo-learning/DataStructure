package algo.Search.BinarySearch;

/**
 * 递归式查找target
 */
public class FindAnyPositionRecurrent implements BinarySearchStrategy{
    @Override
    public int findPosition(int[] nums, int target) {
        return binarySearchRecurrent(nums, 0, nums.length-1, target);
    }

    private int binarySearchRecurrent(int[] arr, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (target == arr[mid]) return mid;
        else if (target < arr[mid]) {
            end = mid-1;
            return binarySearchRecurrent(arr, start, end, target);
        }
        else{
            start = mid+1;
            return binarySearchRecurrent(arr, start, end, target);
        }
    }
}
