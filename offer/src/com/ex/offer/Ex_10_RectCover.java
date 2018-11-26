package com.ex.offer;

public class Ex_10_RectCover {
    public int RectCover(int target) {
        if (target == 1 || target == 2) {
            return target;
        }

        int rect1 = 1;
        int rect2 = 2;

        int rectN = 0;

        for (int i = 3; i <= target; i++) {
            rectN = rect1 + rect2;

            rect1 = rect2;
            rect2 = rectN;
        }

        return rectN;
    }
}
