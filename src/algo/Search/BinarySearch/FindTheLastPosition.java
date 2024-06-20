package algo.Search.BinarySearch;

public class FindTheLastPosition implements BinarySearchStrategy{
    @Override
    public int findPosition(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if (nums.length == 0) return -1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[end] == target) return end;
        if (nums[start] == target) return start;
        return -1;
    }
}
