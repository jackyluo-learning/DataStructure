package algo.Search.BinarySearch;

public class BinarySearchContext {

    private final BinarySearchStrategy strategy;

    public BinarySearchContext(BinarySearchStrategy strategy) {
        this.strategy = strategy;
    }

    public int findPosition(int[] nums, int target) {
        return strategy.findPosition(nums, target);
    }
}
