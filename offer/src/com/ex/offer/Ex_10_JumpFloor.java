package com.ex.offer;

public class Ex_10_JumpFloor {

    public int jumpFloor(int target) {
        if (target == 1 || target == 2) {
            return target;
        }

        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }

    public int JumpFloor(int target) {
        if (target == 1 || target == 2) {
            return target;
        }

        int jump1 = 1;
        int jump2 = 2;
        int jumpN = 0;

        for (int i = 3; i <= target; i++) {
            jumpN = jump1 + jump2;

            jump1 = jump2;
            jump2 = jumpN;
        }

        return jumpN;
    }
}
