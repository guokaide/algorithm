package com.ex.offer;

import java.util.Arrays;

public class Ex_61_ContinuousSequence {
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length < 5) {
            return false;
        }

        Arrays.sort(numbers);

        int numberOfZero = 0;
        int gap = 0;

        for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
            numberOfZero++;
        }

        int small = numberOfZero; // 0之后的第一位索引
        int big = small + 1;

        while (big < numbers.length) {
            if (numbers[small] == numbers[big]) {
                return false;
            }

            gap += numbers[big] - numbers[small] - 1;
            small = big;
            big++;
        }

        return gap > numberOfZero ? false : true;
    }
}
