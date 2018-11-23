package joseph;

/**
 * Joseph Question
 *
 * Solution: 圆圈长度为n时的解f(n,m)可以看成是圆圈长度为n-1时的解f(n-1,m)加m。
 * 但是因为是循环的（圆圈），因此需要对相应的长度取余。
 * f(n,m) = (f(n-1,m) + m) % n n > 1
 * f(n,m) = 0                  n = 1
 */
public class Joseph {
    public int lastRemain(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        if (n == 1) {
            return 0;
        }

        return (lastRemain(n-1, m) + m) % n;
    }

    public int lastRemainIter(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }

        return last;
    }
}
