/**
 * @author xuqiluo
 * @date 2024-06-20
 */
package algo.Search.TwoPointers.OppositeTwoPointers;

import java.util.ArrayList;
import java.util.List;

public class TwoSumStructureWithTwoPointers implements TwoSumStructureStrategy{

    private final List<Integer> nums;

    public TwoSumStructureWithTwoPointers(){
        this.nums = new ArrayList<>();
    }

    @Override
    public void add(int number) {
        this.nums.add(number);
        int index = this.nums.size() - 1;
        while (index > 0 && this.nums.get(index-1) > this.nums.get(index)){
            int temp = this.nums.get(index-1);
            this.nums.set(index-1, this.nums.get(index));
            this.nums.set(index, temp);
            index--;
        }
    }

    @Override
    public boolean find(int target) {
        int left = 0;
        int right = this.nums.size() - 1;
        while (left < right){
            int sum = this.nums.get(left) + this.nums.get(right);
            if(sum == target){
                return true;
            } else {
                if(sum < target){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false;
    }
}
