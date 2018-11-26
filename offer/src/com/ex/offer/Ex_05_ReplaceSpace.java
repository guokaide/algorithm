package com.ex.offer;

/**
 * 2.请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Ex_05_ReplaceSpace {
    public static String replaceSpace(StringBuffer str) {
        String s = str.toString();
        String res = s.replaceAll(" ", "%20");
        return res;
    }

    /**
     * 问题1：替换字符串，是在原来的字符串上做替换，还是新开辟一个字符串做替换！
     * 问题2：在当前字符串替换，怎么替换才更有效率（不考虑java里现有的replace方法）。
     * 从前往后替换，后面的字符要不断往后移动，要多次移动，所以效率低下
     * 从后往前，先计算需要多少空间，然后从后往前移动，则每个字符只移动一次，这样效率更高。
     *
     * @param str
     * @return
     */
    public static String replaceBlank(StringBuffer str) {
        if (str == null) {
            return null;
        }

        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceNum++;
            }
        }

        int len = str.length() + 2 * spaceNum;
        int indexOld = str.length() - 1;
        int indexNew = len - 1;
        str.setLength(len);

        while (indexOld >= 0) {
            if (str.charAt(indexOld) == ' ') {
                str.setCharAt(indexNew--, '0');
                str.setCharAt(indexNew--, '2');
                str.setCharAt(indexNew--, '%');

            } else {
                str.setCharAt(indexNew--, str.charAt(indexOld));
            }

            indexOld--;
        }

        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();
        str.append("We Are Happy");
        String s = replaceBlank(str);
        System.out.print(s);

        System.out.println();

        StringBuffer str1 = new StringBuffer();
        str1.append("");
        String s1 = replaceBlank(str1);
        System.out.print(s1);
    }
}
