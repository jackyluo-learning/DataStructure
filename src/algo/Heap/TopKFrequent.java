package algo.Heap;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequent {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
     */
    private int[][] item;

    private int size;

    public int[] topKFrequent(int[] nums, int k) {
        this.item = new int[k][2];
        this.size = 0;
        Map<Integer, Integer> storage = new HashMap<>();
        for (int each : nums) {
            storage.put(each, storage.getOrDefault(each, 0) + 1);
        }
        System.out.println(storage);
        for (Map.Entry<Integer, Integer> eachPair : storage.entrySet()) {
            Integer key = eachPair.getKey();
            Integer value = eachPair.getValue();
            if (this.size < k) {
                insert(new int[]{key, value});
            } else {
                if (value > this.item[0][1]) {
                    replaceRoot(key, value);
                }
            }
        }
        System.out.println(Arrays.deepToString(this.item));

        int[] result = new int[k];
        int index = 0;
        for (int i = this.size - 1; i >= 0; i--) {
            result[index] = this.item[i][0];
            index++;
        }
        return result;
    }

    private void replaceRoot(int key, int value) {
        this.item[0] = new int[]{key, value};
        heapify(this.size, 0);
    }

    private void insert(int[] val) {
        this.item[this.size] = val;
        int i = this.size;
        while ((i-1)/2 >= 0 && this.item[(i-1)/2][1] > this.item[i][1]) {
            swap(i, (i-1)/2);
            i = (i-1)/2;
        }
        this.size++;
    }

    private void heapify (int size, int i) {
        int maxIndex = i;
        int leftChild = i * 2 + 1;
        int rightChild = i * 2 + 2;
        if (leftChild < size && this.item[maxIndex][1] > this.item[leftChild][1]) {
            maxIndex = leftChild;
        }
        if (rightChild < size && this.item[maxIndex][1] > this.item[rightChild][1]) {
            maxIndex = rightChild;
        }
        if (maxIndex != i) {
            swap(i, maxIndex);
            heapify(size, maxIndex);
        }
    }

    private void swap (int i, int j) {
        int[] iArray = this.item[i];
        this.item[i] = this.item[j];
        this.item[j] = iArray;
    }

    @Test
    public void test () {
        int[] testArray = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(testArray, k)));
    }
}
