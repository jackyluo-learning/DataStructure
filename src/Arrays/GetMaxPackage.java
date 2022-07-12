package Arrays;

import com.sun.xml.internal.xsom.XSUnionSimpleType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GetMaxPackage {
    /**
     * To increase efficiency, the Amazon shipping team will group packages being shipped according to weight. They will merge a lighter package with a heavier package, which eliminates the need for separate shipments.
     * More formally, consider n packages, where packageWeights[i] represents the weight of the nth package. You can combine the ith and (1,11th package if packageWeights[i] a packageWeights[i+1], then discard the th package. After this operation, the number of packages is reduced by 1 and the weight of the i+1 package increases by packageWeights[i]. You can merge the packages any number of times.
     * Find the maximum possible weight of a package that can be achieved after any sequence of merge-operations.
     * Example For example, packages are described as package weights = 2, 9, 10, 3, 7
     * The optimal order of operations is, using 1-based indexing:
     * • Combine the packages at index 2 and index 3, the new array of package weights becomes [2, 19, 3, 7].
     * • Combine the packages at index 1 and Index 2, the new array of package weights becomes [21, 3, 7].
     * • Combine the packages at index 2 and Index 3, the new array of package weights becomes [21, 10].
     * We can not combine the packages anymore.
     */

    public long getHeaviestPackage(List<Integer> list){
        long res = 0;
        int size = list.size();
        int i = size - 1;
        long sum = 0;
        while( i > 0 ){
            int currentValue = list.get(i);
            int previousValue = list.get(i-1);
            if(currentValue > previousValue){
                sum += list.get(i) + list.get(i - 1);
                list.remove(i);
                list.add(i - 1, (int)sum);
                if(res < sum){
                    res = sum;
                }
            }else{
                sum = 0;
                i--;
            }
        }
        return res;
    }

    public long getMaxPackage (List<Integer> list) {
        long res = 0;
        int size = list.size();
        Stack<Integer> storage = new Stack<>();
        for (int i = size - 1; i >= 0; i--) {
            if (storage.isEmpty()) {
                storage.push(list.get(i));
            } else {
                if (list.get(i) < storage.peek()) {
                    int sum = list.get(i) + storage.pop();
                    storage.push(sum);
                    if (sum >= res) {
                        res = sum;
                    }
                } else {
                    storage.push(list.get(i));
                }
            }
        }
        return res;
    }

    @Test
    public void test () {
        List<Integer> input1 = new ArrayList<>();
        input1.add(2);
        input1.add(9);
        input1.add(10);
        input1.add(3);
        input1.add(7);

        List<Integer> input2 = new ArrayList<>();
        input2.add(10);
        input2.add(9);
        input2.add(7);
        input2.add(3);
        input2.add(9);
        Assert.assertEquals(21, getHeaviestPackage(input1));
        Assert.assertEquals(38, getMaxPackage(input2));
    }
}
