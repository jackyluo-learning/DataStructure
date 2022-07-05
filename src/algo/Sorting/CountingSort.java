package algo.Sorting;

public class CountingSort {
    public static int[] countingSort (int[] inputArray) {
        int len = inputArray.length;
        int[] result = new int[len];
        int maxVal = inputArray[0];
        int minVal = inputArray[0];
        for (int j : inputArray) {
            if (j > maxVal) {
                maxVal = j;
            }
            if (j < minVal) {
                minVal = j;
            }
        }
        int offset = maxVal - minVal + 1;
        int[] count = new int[offset + 1];
        for (int i = 0; i < len; i++) {
            count[inputArray[i] - minVal]++;
        }
        //累加前一个的出现次数，作为元素在结果数组的下标（下标-1）
        for (int i = 0; i < offset; i++) {
            count[i+1] += count[i];
        }
        for (int i = 0; i < len; i++) {
            result[count[inputArray[i] - minVal] - 1] = inputArray[i];
            count[inputArray[i] - minVal]--;
        }
        return result;
    }
}
