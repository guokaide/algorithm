package com.ex.offer;

public class Ex_50_FirstNotRepeatedCharInDataFlow {

    private static final int TABLE_SIZE = 256;

    // 保存字符在字符串中的位置
    // -1：初始值
    // -2：重复
    // >= 0：表示第一次出现
    private int[] hashTable = new int[TABLE_SIZE];

    private int index = 0;

    public Ex_50_FirstNotRepeatedCharInDataFlow() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            hashTable[i] = -1;
        }
    }

    //Insert one char from string stream
    public void Insert(char ch)
    {
        if (hashTable[ch] == -1) {
            hashTable[ch] = index;
        } else if (hashTable[ch] >= 0) {
            hashTable[ch] = -2;
        }

        index++;
    }
    //return the first appearance once char in current string stream
    public char FirstAppearingOnce()
    {
        char c = '#';
        int minIndex = Integer.MAX_VALUE;

        for (int i = 0; i < TABLE_SIZE; i++) {
            if (hashTable[i] >= 0 && hashTable[i] < minIndex) {
                c = (char)i;
                minIndex = hashTable[i];
            }
        }

        return c;
    }
}
