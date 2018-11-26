package com.ex.offer;

/**
 * 当模式中的第二个字符不是“*”时：
 * 1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
 * 2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。
 *
 * 而当模式中的第二个字符是“*”时：
 * 如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
 * 1、模式后移2字符，相当于x*被忽略；
 * 2、字符串后移1字符，模式后移2字符；
 * 3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
 */
public class Ex_19_Match {

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }

        return matchCore(str, 0, pattern, 0);
    }

    private boolean matchCore(char[] str, int strIndex, char[] pattern, int patIndex) {
        // 有效性检验： str 和 pattern都到尾，则匹配成功
        if (strIndex == str.length && patIndex == pattern.length) {
            return true;
        }

        // pattern 先到尾，则匹配失败
        if (strIndex != str.length && patIndex == pattern.length) {
            return false;
        }

        // pattern第2个是*，且str第1个和pattern第1个匹配，分3种情况；若不匹配，则pattern后移2位
        if (patIndex + 1 < pattern.length && pattern[patIndex + 1] == '*') {
            if (strIndex != str.length && (pattern[patIndex] == str[strIndex] || pattern[patIndex] == '.')) {
                return matchCore(str, strIndex, pattern, patIndex+2) // 模式串后移2位，相当于忽略x*
                        || matchCore(str, strIndex+1, pattern, patIndex+2) // 字符串，模式串都后移1位，相当于忽略*
                        || matchCore(str, strIndex+1, pattern, patIndex); // 字符串后移1位，相当于*之前扩展了。
            } else {
                return matchCore(str, strIndex, pattern, patIndex+2);
            }
        }

        // pattern第2个不是* ，且str 第1个和pattern第1个匹配，则后移一位，否则直接返回false
        if (strIndex != str.length && (pattern[patIndex] == str[strIndex] || pattern[patIndex] == '.')) {
            return matchCore(str, strIndex+1, pattern, patIndex+1);
        }

        return false;
    }
}
