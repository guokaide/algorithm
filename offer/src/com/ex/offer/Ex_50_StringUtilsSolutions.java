package com.ex.offer;

import org.junit.Test;

import java.util.HashMap;

public class Ex_50_StringUtilsSolutions {

    public String deleteString(String str1, String str2) {
        if (str1 == null || str1.length() <= 0) return null;

        if (str2 == null || str2.length() <= 0) return str1;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0;  i < str2.length(); i++) {
            map.put(str2.charAt(i), 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            if (!map.containsKey(str1.charAt(i))) {
                sb.append(str1.charAt(i));
            }
        }

        return sb.toString();
    }

    public String deleteDuplicatedChar(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 1);
            } else {
                map.put(str.charAt(i), map.get(str.charAt(i)).intValue() + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)).intValue() > 1) {
                sb.append(str.charAt(i));
                map.put(str.charAt(i), 0);
            }

            if (map.get(str.charAt(i)).intValue() == 1) {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    public boolean isAnagram(String str1, String str2) {
        if (str1 == null || str1.length() <= 0 || str2 == null || str2.length() <= 0 || str1.length() != str2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            if (!map.containsKey(str1.charAt(i))) {
                map.put(str1.charAt(i), 1);
            } else {
                map.put(str1.charAt(i), map.get(str1.charAt(i)).intValue() + 1);
            }
        }

        for (int i = 0; i < str2.length(); i++) {
            if (map.containsKey(str2.charAt(i))) {
                map.put(str2.charAt(i), map.get(str2.charAt(i)).intValue()-1);
            }
        }

        for (Character c : map.keySet()) {
            if (map.get(c).intValue() != 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testDeleteString() {
        String str1 = "We are students";
        String str2 = "aeiou";
        System.out.println(deleteString(str1, str2));
    }

    @Test
    public void testDeleteDuplicatedChar() {
        String str = "google";
        System.out.println(deleteDuplicatedChar(str));
    }

    @Test
    public void testIsAnagram() {
        String str1 = "silent";
        String str2 = "listen";
        String str3 = "livexy";
        System.out.println(isAnagram(str1, str2));
        System.out.println(isAnagram(str1, str3));
    }

}
