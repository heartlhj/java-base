package com.lhj.base;

import lhj.base.Stack;
import org.junit.Assert;
import org.junit.Test;

/**
 * @ProjectName: java-base
 * @Package: com.base.test
 * @ClassName: StackTest
 * @Author: LiAy
 * @Description: 栈测试
 * @Date: 2019-8-19 21:56
 * @Version: 1.0
 */
public class StackTest {

    @Test
    public void stack(){
        Stack stack = new Stack();
        stack.push("123");
        stack.push("abc");
        stack.push(456);
        stack.push(789);
        Assert.assertEquals(stack.get(2).data,456);
    }
}
