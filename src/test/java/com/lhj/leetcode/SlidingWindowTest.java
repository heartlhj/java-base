package com.lhj.leetcode;

import lhj.leetcode.SlidingWindow;
import org.junit.Test;

public class SlidingWindowTest {

    /**
     * 输入：s = "abcd", t = "bcdf", cost = 3
     * 输出：3
     * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
     */
    @Test
    public void test() {
        System.out.println(SlidingWindow.equalSubstring("abcd", "bcdf", 3));
    }

    /**
     * 输入：s = "abcd", t = "acde", cost = 3
     * 输出：1
     * 解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
     */
    @Test
    public void test1() {
        System.out.println(SlidingWindow.equalSubstring("abcd", "gcdf", 3));
    }

    /**
     * 输入：s = "pxezla", t = "loewbi", cost = 25
     * 输出：1
     * 解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
     */
    @Test
    public void test2() {
        System.out.println(SlidingWindow.equalSubstring("pxezla", "loewbi", 25));
    }

}
