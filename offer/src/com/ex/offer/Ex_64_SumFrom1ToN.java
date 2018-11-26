package com.ex.offer;

import org.junit.Test;

public class Ex_64_SumFrom1ToN {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean stop = (n > 0) && ((sum += Sum_Solution(n-1)) > 1);
        return sum;
    }

    @Test
    public void test() {
        System.out.println(Sum_Solution(10));
    }

}




