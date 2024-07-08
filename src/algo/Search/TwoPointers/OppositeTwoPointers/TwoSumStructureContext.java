/**
 * @author xuqiluo
 * @date 2024-06-20
 */
package algo.Search.TwoPointers.OppositeTwoPointers;

public class TwoSumStructureContext {

    private final TwoSumStructureStrategy strategy;

    public TwoSumStructureContext(TwoSumStructureStrategy strategy) {
        this.strategy = strategy;
    }

    public void add(int number){
        this.strategy.add(number);
    }

    public boolean find(int target){
        return this.strategy.find(target);
    }

}
