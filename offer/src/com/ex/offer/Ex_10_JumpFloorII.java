package com.ex.offer;

/**
 * f(n)
 * f(1) = 1;
 * f(2) = f(2-1) + f(2-2) = 1 + 1 = 2;
 * f(3) = f(3-1) + f(3-2) + f(3-2)
 *        = f(0) + f(1) + f(2)
 * f(n-1) = f(0) + f(1) + f(2) + ... + f(n-2)
 * f(n)   = f(0) + f(1) + f(2) + ... + f(n-2) + f(n-1)
 *        = f(n-1) + f(n-1)
 *        = 2 * f(n-1)
 *        = 2 ^ 2 * f(n-2)
 *        = ...
 *        = 2 ^ (n-1) * f(1)
 *        = 2 ^ (n-1)
 *
 * f(n) = 2 ^ (n-1)
 */
public class Ex_10_JumpFloorII {

    public static int JumpFloorII(int target) {
        if (target == 1) {
            return 1;
        }
        int res = 1;
        for (int i = 1; i < target; i++) {
            res *= 2;
        }

        return res;
    }
}
