package com.ex.offer;

import java.util.HashMap;

public class Ex_50_FirstNotRepeatedChar {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() < 1) {
            return -1;
        }

        int[] hashTable = new int[256]; // 简单的HashTable

        for (int i = 0; i < 256; i++) {
            hashTable[i] = 0;
        }

        for (int i = 0; i < str.length(); i++) {
            hashTable[str.charAt(i)]++;
        }

        int index = -1;

        for (int i = 0; i < str.length(); i++) {
            if (hashTable[str.charAt(i)] == 1) {
                index = i;
                break;
            }
        }

        return index;
    }


    public int FirstNotRepeatingChar1(String str) {
        if (str == null || str.length() < 1) {
            return -1;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 1);
            } else {
                int count = map.get(str.charAt(i)).intValue() + 1;
                map.put(str.charAt(i), count);
            }
        }

        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)).intValue() == 1) {
                index = i;
                break;
            }
        }
        return index;
    }
}
