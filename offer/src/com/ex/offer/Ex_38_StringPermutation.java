package com.ex.offer;

import java.util.ArrayList;
import java.util.Collections;

public class Ex_38_StringPermutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() <= 0) return res;

        permutation(str.toCharArray(), 0, res);
        Collections.sort(res);
        return res;
    }

    private void permutation(char[] chars, int startIndex, ArrayList<String> res) {
        if (startIndex == chars.length-1) {
            String str = String.valueOf(chars);
            if (!res.contains(str)) {
                res.add(str);
            }
        } else {
            // 第一个字符与后面所有字符逐个交换：a|bcde   b|acde  c|bade d|bcae e|bcda
            // 第一个字符固定，第二个字符和后面所有字符逐个交换：a || b|cde c|bde d|cbe e|cdb
            for (int i = startIndex; i < chars.length; i++) {
                swap(chars, startIndex, i);
                permutation(chars, startIndex + 1, res);  // a || b|cde c|bde d|cbe e|cdb
                swap(chars, startIndex, i);
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }


}
