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
        for (int j : inputArray) {
            count[j - minVal]++;
        }
        //累加前一个的出现次数，作为元素在结果数组的下标（下标-1）
        for (int i = 0; i < offset; i++) {
            count[i+1] += count[i];
        }
        for (int j : inputArray) {
            result[count[j - minVal] - 1] = j;
            count[j - minVal]--;
        }
        return result;
    }
}
