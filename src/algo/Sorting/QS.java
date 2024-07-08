package algo.Sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * 1. 分：快速排序通过选取一个基准元素，将数组分为两个子数组，一个子数组的所有元素都比基准元素小，另一个子数组的所有元素都比基准元素大。
 * 这个过程的时间复杂度是O(n)，因为我们需要遍历数组一次。
 * 2. 治：然后我们递归地对两个子数组进行快速排序。
 * 由于我们每次都将数组分为两个大致相等的部分，所以每一层的递归我们都处理大约n个元素，而递归的深度为log n。
 * 开始时有n个元素，那么在第一次递归调用后，我们需要处理的元素数量减少到大约n/2。在第二次递归调用后，元素数量再次减半，变为大约n/4。以此类推，直到我们只剩下一个元素需要处理。
 * 因此，我们需要进行的递归调用次数（也就是递归的深度）是log n（以2为底）。
 * 3.
 * 因此，这个过程的平均时间复杂度是O(n log n)。
 * 如果在最坏情况下，不幸地选择最大或最小的元素作为基准元素，那么每次分区只能将数组分为一个元素和其余元素两部分，这样递归树的深度就变为n，所以最坏情况下的时间复杂度是O(n^2)。
 */
public class QS {
    private static final Random RANDOM = new Random();

    private static void swap(int[] inputArray, int i, int j){
        int temp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = temp;
    }

    private static int partition(int[] inputArray, int start, int end){
        int pivotIndex = RANDOM.nextInt(end - start) + start;
        int pivot = inputArray[pivotIndex];
        int smallPointer = start-1;
        swap(inputArray, pivotIndex, end);
        for (int i = start; i<end; i++){
            if(inputArray[i] <= pivot){
                smallPointer++;
                swap(inputArray, smallPointer, i);
            }
        }
        swap(inputArray, smallPointer+1, end);
        return smallPointer+1;
    }

    private static void qs(int[] inputArray, int start, int end){
        if(end > start) {
            int pivot = partition(inputArray, start, end);
            qs(inputArray, start, pivot-1);
            qs(inputArray, pivot + 1, end);
        }
    }

    public static int[] quickSort(int[] inputArray) {
        if (inputArray == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        int[] workingArray = Arrays.copyOf(inputArray, inputArray.length);
        qs(workingArray, 0, workingArray.length - 1);
        return workingArray;
    }
}