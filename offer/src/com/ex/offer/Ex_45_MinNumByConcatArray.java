package com.ex.offer;

import java.util.Arrays;
import java.util.Comparator;

// 最小字典序问题
public class Ex_45_MinNumByConcatArray {
    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length <= 0) {
            return "";
        }

        String[] strs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strs, new StrComparator());

        String res = "";
        for (String str : strs) {
             res += str;
        }

        return res;
    }

    private static class StrComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return (o1+o2).compareTo(o2+o1);
        }
    }
}
