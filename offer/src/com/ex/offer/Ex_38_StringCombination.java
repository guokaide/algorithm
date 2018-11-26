package com.ex.offer;

import org.junit.Test;

import java.util.ArrayList;

public class Ex_38_StringCombination {
    public ArrayList<String> Combination(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() <= 0) return res;

        combination(str.toCharArray(), 0, res);
        return res;
    }

    private void combination(char[] chars, int startIndex, ArrayList<String> res) {
        if (startIndex == chars.length) {
            StringBuilder sb = new StringBuilder();
            for (char c : chars) {
                if (c != 0) sb.append(c);
            }

            res.add(sb.toString());
            return;
        }

        combination(chars, startIndex+1, res);
        char temp = chars[startIndex];
        chars[startIndex] = 0;
        combination(chars, startIndex+1, res);
        chars[startIndex] = temp;
    }

    @Test
    public void test() {
        ArrayList<String> res = Combination(new String("abc"));
        for (String str : res) {
            System.out.println(str);
        }
    }


}
