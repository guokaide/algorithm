package array;

import org.junit.Assert;
import org.junit.Test;

public class MinNumberInRotatedArrayTest {

    @Test
    public void testGetMinNumber() {
        int[] arr = new int[] {3,4,5,1,2};
        int expected = 1;
        Assert.assertEquals(expected, MinNumberInRotatedArray.getMinNumber(arr));

        int[] arr1 = new int[] {1,2,3,4,5};
        Assert.assertEquals(expected, MinNumberInRotatedArray.getMinNumber(arr1));

        int[] arr2 = new int[] {1,0,1,1,1};
        int expected1 = 0;
        Assert.assertEquals(expected1, MinNumberInRotatedArray.getMinNumber(arr2));

        int[] arr3 = new int[] {1,1,1,0,1};
        Assert.assertEquals(expected1, MinNumberInRotatedArray.getMinNumber(arr3));
    }
}
