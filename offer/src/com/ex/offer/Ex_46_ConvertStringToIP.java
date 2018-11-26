package com.ex.offer;

/**
 * 附加题目
 *
 * problem 5: [String][递归][动态规划]
 *
 * 给定一个由数字组成的字符串， 请返回能返回多少种合法的ipv4组合。
 *
 * 知识点：
 * IPv4: 点分十进制
 * 1. x.x.x.x: 4 parts
 * 2. 0 <= x <= 255
 * 3. x不能有0a这种形式
 */
public class Ex_46_ConvertStringToIP {

    public static int convertStringToIp1(String str) {
        if (str == null || str.length() < 4 || str.length() > 12) {
            return 0;
        }

        char[] chars = str.toCharArray();
        return process1(chars, 0, 0);
    }

    /**
     *
     * @param chars
     * @param i       0~i-1已经形成合法的IPv4的部分，考察i~N-1能组合出多少种
     * @param parts   0~i-1已经形成合法IPv4的部分的部分数
     * @return
     */
    public static int process1(char[] chars, int i, int parts) {
//        if (i > chars.length || parts > 4) {
//            return 0;
//        }

        if (i == chars.length) {
            return parts == 4 ? 1 : 0;
        }

        int res = 0;

        res += process1(chars, i+1, parts+1);

        if (chars[i] == '0') {
            return res;
        }

        if (i + 2 <= chars.length) {
            res += process1(chars, i+2, parts+1);
        }

        if (i + 3 <= chars.length) {
            int sum = (chars[i] - '0') * 100 + (chars[i+1] - '0') * 10 + (chars[i+2] - '0');
            if (sum <= 255) {
                return res + process1(chars, i+3, parts + 1);
            }
        }

        return res;
    }

    public static int convertStringToIp2(String str) {
        if (str == null || str.length() < 4 || str.length() > 12) {
            return 0;
        }

        char[] chars = str.toCharArray();
        int[][] dp = new int[chars.length+1][6];

        dp[chars.length][4] = 1;

        for (int i = dp.length-2; i >= 0; i--) {
            for (int j = dp[i].length - 2; j >= 0; j--) {

                 dp[i][j] = dp[i+1][j+1];

                if (chars[i] != '0') {
                    if (i+2 < dp.length) {
                        dp[i][j] = dp[i][j] + dp[i+2][j+1];
                    }

                    if (i+3 < dp.length) {
                        int sum = (chars[i] - '0') * 100 + (chars[i+1] - '0') * 10 + (chars[i+2] - '0');
                        if (sum < 256) {
                            dp[i][j] = dp[i][j] + dp[i + 3][j + 1];
                        }
                    }
                }
            }
        }
        return dp[0][0];
    }

    public static String getRandomNumberString() {
        char[] chas = new char[(int) (Math.random() * 10) + 3];
        for (int i = 0; i < chas.length; i++) {
            chas[i] = (char) (48 + (int) (Math.random() * 10));
        }
        return String.valueOf(chas);
    }

    public static void main(String[] args) {
        int testTime = 3000000;
        boolean hasErr = false;
        for (int i = 0; i < testTime; i++) {
            String test = getRandomNumberString();
            if (convertStringToIp1(test) != convertStringToIp2(test)) {
                hasErr = true;
            }
        }
        if (hasErr) {
            System.out.println("233333");
        } else {
            System.out.println("666666");
        }

    }
}
