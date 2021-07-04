package io.gkd.week02;

import java.util.HashMap;
import java.util.Map;

/**
 * Easy
 * 697. https://leetcode-cn.com/problems/degree-of-an-array/
 */
public class Lc697_FindShortestSubArray {
    public int findShortestSubArray(int[] nums) {
        // map:
        // key - element
        // value - value[]
        // - value[0]: element count;
        // - value[1]: first element index;
        // - value[2]: last element index
        HashMap<Integer, int[]> map = new HashMap<>();
        int degree = 0;
        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            if (map.containsKey(element)) {
                int[] value = map.get(element);
                value[0]++;
                value[2] = i;
                degree = Math.max(degree, value[0]);
            } else {
                map.put(element, new int[] {1, i, i});
                degree = Math.max(degree, 1);
            }
        }
        // System.out.println(degree);
        int shortestSubArrayLen = 50000;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] value = entry.getValue();
            if (degree == value[0]) {
                shortestSubArrayLen = Math.min(shortestSubArrayLen, value[2] - value[1] + 1);
            }
        }
        return shortestSubArrayLen;
    }
}
