package com.ex.offer;

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Ex_56_AppearanceOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length < 2) {
            return;
        }

        int xor = 0;
        for (int i = 0; i < array.length; i++) {
            xor = xor ^ array[i];   // xor = a ^ b =  num1[0] ^ num2[0]
        }

        int indexOf1 = findFirst1_Bit(xor);

        for (int i = 0; i < array.length; i++) {
            if (is1_Bit(array[i], indexOf1)) {
                num1[0] = num1[0] ^ array[i];
            } else {
                num2[0] = num2[0] ^ array[i];
            }
        }
    }

    // 从右到左第1bit为1的index
    private int findFirst1_Bit(int num) {
        int index = 0;
        int len = 8 * 4;
        while (index < len && (num & 1) == 0) {
            num = num >> 1;
            index++;
        }
        return index;
    }

    // 判断从右到左第index位是不是1
    private boolean is1_Bit(int num, int index) {
        num = num >> index;
        return (num & 1) == 1;
    }


}
