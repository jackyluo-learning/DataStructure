/**
 * @author xuqiluo
 * @date 2024-06-20
 */
package algo.Search.TwoPointers.OppositeTwoPointers;

import java.util.HashMap;
import java.util.Map;

/**
 * 设计并实现一个 TwoSum 类。他需要支持以下操作:add 和 find。
 * add -把这个数添加到内部的数据结构。
 * find -是否存在任意一对数字之和等于这个值
 */
public class TwoSumStructureWithMap implements TwoSumStructureStrategy{

    private final Map<Integer, Integer> storage;

    public TwoSumStructureWithMap(){
        this.storage = new HashMap<>();
    }

    @Override
    public void add(int number){
        this.storage.put(number, this.storage.getOrDefault(number, 0) + 1);
    }

    @Override
    public boolean find(int target){
        for (Integer num1 : this.storage.keySet()){
            int num2 = target - num1;
            int desireCount = num1 == num2 ? 2 : 1;
            if(this.storage.containsKey(num2) && this.storage.get(num2) >= desireCount){
                return true;
            }
        }
        return false;
    }
}
