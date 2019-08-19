package com.base.test;

import com.base.Linked;
import org.junit.Assert;
import org.junit.Test;

/**
 * @ProjectName: java-base
 * @Package: com.base.test
 * @ClassName: LinkedTest
 * @Author: LiAy
 * @Description: 链表测试
 * @Date: 2019-8-18 21:37
 * @Version: 1.0
 */
public class LinkedTest {

    @Test
    public void linked(){
        Linked linked = new Linked();
        linked.add("123");//size==0
        linked.insert("455",0);
        linked.insert("455",2);
        Assert.assertEquals(linked.get(1).data.toString(), "123");
    }
}
