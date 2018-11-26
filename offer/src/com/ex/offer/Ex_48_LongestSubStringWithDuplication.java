package com.ex.offer;

import org.junit.Test;

// 这个题目和Ex_42_MaxSumOfSubArray类似
public class Ex_48_LongestSubStringWithDuplication {
    public int longestSubString(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }

        int curLen = 0;
        int maxLen = 0;

        // 注意这里利用一个int[]记录了每个字符上次出现的位置，这样就可以计算出每个位置和他上次出现位置的距离
        // 注意其下标为：char - 'a'
        int[] lastPositions = new int[26];  // 某个字符上一次出现的索引，从未出现为-1；

        for (int i = 0; i < 26; i++) {
            lastPositions[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            int lastIndex = lastPositions[str.charAt(i) - 'a'];
            int distance = i - lastIndex;
            if (lastIndex < -1 || distance > curLen) {
                curLen++;
            } else {
                curLen = distance;
            }

            if (curLen > maxLen) maxLen = curLen;

            lastPositions[str.charAt(i) - 'a'] = i; // 更新最后出现位置
        }

        return Math.max(maxLen, curLen);
    }

    @Test
    public void test() {
        String str = "arabcacfr";
        System.out.println(longestSubString(str));
    }

}
