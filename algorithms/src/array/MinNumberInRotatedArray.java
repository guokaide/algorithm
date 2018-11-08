package array;

public class MinNumberInRotatedArray {

    public static int getMinNumber(int[] arr) {
        if (arr == null || arr.length < 1) {
            throw new IllegalArgumentException("Invalid Array!");
        }

        // 循环不变条件 [左侧递增数组 | 右侧递增数组]
        int l = 0;                 // l始终指向左侧递增数组
        int r = arr.length-1;      // r始终指向右侧递增数组

        while (arr[l] >= arr[r]) {
            if (r - l == 1) {
                return arr[r];
            }

            int mid = l + ((r-l) >> 1);

            // 若 arr[l] == arr[r] && arr[l] == arr[mid],
            // arr[mid]无法判定属于左侧递增数组还是右侧递增数组，因此只能顺序查找
            if (arr[l] == arr[r] && arr[l] == arr[mid]) {
                return getMinInOrder(arr, l, r);
            }

            if (arr[mid] >= arr[l]) {
                l = mid;
            } else if (arr[mid] <= arr[r]) {
                r = mid;
            }
        }

        return arr[l]; // 若数组是已经排序的数组（从小到大），min = arr[l]。
    }

    private static int getMinInOrder(int[] arr, int l, int r) {
        int min = arr[l];
        for (int i = l+1 ; i <= r; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return min;
    }
}
