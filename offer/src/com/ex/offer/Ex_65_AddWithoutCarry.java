package com.ex.offer;

public class Ex_65_AddWithoutCarry {
    public int Add(int num1,int num2) {
        int sum = 0;
        int carry = 0;
        do {
            sum = num1 ^ num2; //不进位加法（不断执行不进位加法，直到进位为0，则不进位加法=进位加法）
            carry = (num1 & num2) << 1;

            num1 = sum;
            num2 = carry;
        } while (num2 != 0);

        return sum;
    }
}
