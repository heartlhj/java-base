package com.lhj.base;

import lhj.base.Queue;
import org.junit.Assert;
import org.junit.Test;

/**
 * @ProjectName: java-base
 * @Package: com.base.test
 * @ClassName: QueneTest
 * @Author: LiAy
 * @Description: 队列测试
 * @Date: 2019-8-19 22:31
 * @Version: 1.0
 */
public class QueneTest {

    @Test
    public void array(){
        try {
            Queue queue = new Queue(10);
            queue.add(1);
            queue.add(2);
            queue.add(3);
            queue.add(4);
            queue.add(5);
            Assert.assertEquals(queue.peek(),1);
            Assert.assertEquals(queue.peek(),1);
            Assert.assertEquals(queue.poll(),1);
            Assert.assertEquals(queue.poll(),2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
