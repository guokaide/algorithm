package array;

public class BinarySearch {

    public static int binarySearch(int[] array, int target) {
        int lo = 0;
        int hi = array.length-1; // 始终在[lo, hi]范围内查找target

        while (lo <= hi) {
            int mid = lo + (hi - lo) >> 1;

            if (array[mid] >  target) {
                hi = mid - 1;
            } else if (array[mid] < target) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

}
