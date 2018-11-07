package array;

public class BinarySearch {

    // 迭代
    public static int binarySearch(int[] array, int target) {
        int lo = 0;
        int hi = array.length-1; // 始终在[lo, hi]范围内查找target

        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1); // 这里若是 (lo + hi) / 2 有可能造成整型溢出

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

    // 递归
    public static int binarySearchRecur(int[] array, int target) {
        return bs(array, target, 0, array.length-1);
    }

    private static int bs(int[] array, int target, int lo, int hi) {
        if (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (array[mid] > target) {
                return bs(array, target, lo, mid-1);
            } else if (array[mid] < target) {
                return bs(array, target, mid+1, hi);
            } else {
                return mid;
            }
        }

        return -1;
    }
}
