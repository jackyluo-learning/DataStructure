package algo.Sorting;

import java.util.Arrays;

public class MS {
    /*
    Merge Sorting
    总时间=分解时间+解决问题时间+合并时间。
    分解时间就是把一个待排序序列分解成两序列，时间为一常数，时间复杂度o(1).
    解决问题时间是两个递归式，把一个规模为n的问题分成两个规模分别为n/2的子问题，时间为2T(n/2).
    合并f(n),时间复杂度为o（n）
    T(n)=2T(n/2)+f(n)
    T(n)=4T(n/4)+2f(n)
    ...
    T(n)=2^k(n/2^k)+2^(k-1)f(n),
    设log2n=k,共进行k层递归
    T(n)= nT(1)+kf(n)
        = nT(1)+nlog2n*f(n)
        = O(n*logn)
     */
    public static int[] mergeSort(int[] inputArray) {
        int[] workArray = Arrays.copyOf(inputArray, inputArray.length);
        int len = inputArray.length;
        if (len < 2) return workArray;
        int mid = len / 2;
        int[] left = Arrays.copyOfRange(inputArray, 0, mid);
        int[] right = Arrays.copyOfRange(inputArray, mid, len);
        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int result_len = left.length + right.length;
        int[] result = new int[result_len];
        for (int index = 0, lefti = 0, righti = 0; index < result_len; index++) {
            if (lefti >= left.length) {
                result[index] = right[righti++];
            } else if (righti >= right.length) {
                result[index] = left[lefti++];
            } else if (left[lefti] < right[righti]) {
                result[index] = left[lefti++];
            } else if (left[lefti] >= right[righti]) {
                result[index] = right[righti++];
            }
        }
        return result;
    }
}
