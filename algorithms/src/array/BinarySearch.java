package array;

public class BinarySearch {
    // 最简单的二分查找算法：针对有序无重复元素数组
    // 迭代
    public static int binarySearch(int[] array, int target) {
        if (array == null) return -1;

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
        if (array == null) return -1;
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

    // 二分查找变形问题
    // 1. 查找第一个值等于给定值的元素
    public static int bsFirst(int[] array, int target) {
        int lo = 0;
        int hi = array.length - 1;

        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);

            if (array[mid] > target) {
                hi = mid - 1;
            } else if (array[mid] < target) {
                lo = mid + 1;
            } else {
                if (mid == lo || array[mid-1] != array[mid]) {
                    return mid;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }

    // 2. 查找最后一个值等于给定值的元素
    public static int bsLast(int[] array, int target) {
        int lo = 0;
        int hi = array.length - 1;

        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);

            if (array[mid] > target) {
                hi = mid - 1;
            } else if (array[mid] < target) {
                lo = mid + 1;
            } else {
                if (mid == hi || array[mid] != array[mid+1]) {
                    return mid;
                } else {
                    lo = mid + 1;
                }
            }
        }

        return -1;
    }

    // 3. 查找第一个大于等于给定值的元素
    public static int bsFistGE(int[] array, int target) {
        int lo = 0;
        int hi = array.length - 1;

        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);

            if (array[mid] >= target) {
                if (mid == 0 || array[mid-1] < target) {
                    return mid;
                } else {
                    hi = mid - 1;
                }
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }

    // 4. 查找最后一个小于等于给定值的元素
    public static int bsLastLE(int[] array, int target) {
        int lo = 0;
        int hi = array.length - 1;

        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);

            if (array[mid] <= target) {
                if (mid == hi || array[mid+1] > target) {
                    return mid;
                } else {
                    lo = mid + 1;
                }
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }
}
