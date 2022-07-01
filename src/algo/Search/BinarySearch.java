package algo.Search;

public class BinarySearch {

    public int binarySearchRecurrent(int[] arr, int start, int end, int target) {
        if (target > arr[end] || target < arr[end] || start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (target == mid) return mid;
        else if (target < mid) {
            end = mid - 1;
            return binarySearchRecurrent(arr, start, end, target);
        }
        else{
            start = mid+1;
            return binarySearchRecurrent(arr, start, end, target);
        }
    }

    public int binarySearchLoop(int[] arr, int target){
        int len = arr.length;
        int start = 0;
        int end = len - 1;
        if (target < arr[start] || target > arr[end] || start > end){
            return -1;
        }

        while(start <= end){
            int mid = (start+end) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target){
                start = mid+1;
            }else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
