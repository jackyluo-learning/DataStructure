package algo.Sorting;

import java.util.Arrays;

public class HS {
    /**
     * 建堆：
     * 1. 从下往上(插入)
     * 2. 从上往下(原地建堆)
     */

    private int[] item;

    private int size;

    public HS (int num) {
        this.item = new int[num];
        this.size = 0;
    }

    public HS (int[] num) {
        this.item = Arrays.copyOf(num, num.length);
        this.size = num.length;
    }

    public void buildHeap (int[] originArray) {
        int len = originArray.length;
        for (int i = 0; i < len; i++) {
            insert(originArray[i]);
        }
    }

    public void buildHeap (){
        int size = this.item.length;
        for (int i = size/2 - 1; i >= 0; i--) {
            heapify(size, i);
        }
    }

    private void insert(int val) {
        this.item[this.size] = val;
        int i = this.size;
        while ((i-1)/2 >= 0 && this.item[(i-1)/2] < this.item[i]) {
            swap(i, (i-1)/2);
            i = (i-1)/2;
        }
        this.size++;
    }

    private void heapify (int size, int i) {
            int maxIndex = i;
            int leftChild = i * 2 + 1;
            int rightChild = i * 2 + 2;
            if (leftChild < size && this.item[maxIndex] < this.item[leftChild]) {
                maxIndex = leftChild;
            }
            if (rightChild < size && this.item[maxIndex] < this.item[rightChild]) {
                maxIndex = rightChild;
            }
            if (maxIndex != i) {
                swap(i, maxIndex);
                heapify(size, maxIndex);
            }
    }

    public int[] sort() {
        int len = this.item.length;
        buildHeap();
        for (int i = len - 1; i >= 0; i--) {
            swap(0, i);
            len--;
            heapify(len, 0);
        }
        return Arrays.copyOf(this.item, this.size);
    }

    public int[] sort (int[] originArray) {
        int len = originArray.length;
        buildHeap(originArray);
        for (int i = len - 1; i >= 0; i--) {
            swap(0, i);
            len--;
            heapify(len, 0);
        }
        return Arrays.copyOf(this.item, this.size);
    }

    private void swap (int i1, int i2) {
        int tmp = this.item[i2];
        this.item[i2] = this.item[i1];
        this.item[i1] = tmp;
    }

    public void printArray () {
        System.out.println(Arrays.toString(this.item));
    }
}


