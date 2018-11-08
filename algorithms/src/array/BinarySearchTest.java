package array;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

    // 测试示例（完备）
    @Test
    public void testBinarySearch() {
        int notFound = -1;
        int target = 6;

        // 测试数组为null
        int[] arr = null;
        Assert.assertEquals(notFound, BinarySearch.binarySearch(arr, target));

        // 测试数组为空
        int[] arr1 = new int[0];
        Assert.assertEquals(notFound, BinarySearch.binarySearch(arr1, target));

        // 功能测试
        int[] arr2 = new int[] {3,4,5,6,8,9,12,20,25};

        // 功能测试：not Found
        int target1 = 30;
        Assert.assertEquals(notFound, BinarySearch.binarySearch(arr2, target1));

        // 功能测试：Found
        int target2 = 5;
        int expected = 2;
        Assert.assertEquals(expected, BinarySearch.binarySearch(arr2, target2));
    }

    @Test
    public void testBinarySearchRecur() {
        int notFound = -1;
        int target = 6;

        // 测试数组为null
        int[] arr = null;
        Assert.assertEquals(notFound, BinarySearch.binarySearchRecur(arr, target));

        // 测试数组为空
        int[] arr1 = new int[0];
        Assert.assertEquals(notFound, BinarySearch.binarySearchRecur(arr1, target));

        // 功能测试
        int[] arr2 = new int[] {3,4,5,6,8,9,12,20,25};

        // 功能测试：not Found
        int target1 = 30;
        Assert.assertEquals(notFound, BinarySearch.binarySearchRecur(arr2, target1));

        // 功能测试：Found
        int target2 = 5;
        int expected = 2;
        Assert.assertEquals(expected, BinarySearch.binarySearchRecur(arr2, target2));
    }

    // 以下只进行功能测试
    @Test
    public void testBsFirst() {
        int[] arr = new int[] {3,4,5,5,5,6,8,9,12,20,25};
        int target = 5;
        int expected = 2;

        Assert.assertEquals(expected, BinarySearch.bsFirst(arr, target));

        int target1 = 6;
        int expected1 = 5;
        Assert.assertEquals(expected1, BinarySearch.bsFirst(arr, target1));

        int target2 = 30;
        int expected2 = -1;
        Assert.assertEquals(expected2, BinarySearch.bsFirst(arr, target2));
    }

    @Test
    public void testBsLast() {
        int[] arr = new int[] {3,4,5,5,5,6,8,9,12,20,25};
        int target = 5;
        int expected = 4;

        Assert.assertEquals(expected, BinarySearch.bsLast(arr, target));

        int target1 = 6;
        int expected1 = 5;
        Assert.assertEquals(expected1, BinarySearch.bsLast(arr, target1));

        int target2 = 30;
        int expected2 = -1;
        Assert.assertEquals(expected2, BinarySearch.bsLast(arr, target2));
    }

    @Test
    public void testBsFirstGE() {
        int[] arr = new int[] {3,4,5,5,5,6,8,9,12,20,25};
        int target = 5;
        int expected = 2;

        Assert.assertEquals(expected, BinarySearch.bsFistGE(arr, target));

        int target1 = 7;
        int expected1 = 6;
        Assert.assertEquals(expected1, BinarySearch.bsFistGE(arr, target1));

        int target2 = 30;
        int expected2 = -1;
        Assert.assertEquals(expected2, BinarySearch.bsFistGE(arr, target2));
    }

    @Test
    public void testBsLastLE() {
        int[] arr = new int[] {3,4,5,5,5,6,8,9,12,20,25};
        int target = 5;
        int expected = 4;

        Assert.assertEquals(expected, BinarySearch.bsLastLE(arr, target));

        int target1 = 7;
        int expected1 = 5;
        Assert.assertEquals(expected1, BinarySearch.bsLastLE(arr, target1));

        int target2 = -2;
        int expected2 = -1;
        Assert.assertEquals(expected2, BinarySearch.bsLastLE(arr, target2));
    }
}
