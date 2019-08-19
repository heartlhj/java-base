package com.base.test;

import com.base.Array;
import org.junit.Assert;
import org.junit.Test;

/**
 * @ProjectName: java-base
 * @Package: com.base.test
 * @ClassName: ArrayTest
 * @Author: LiAy
 * @Description: Array数组测试
 * @Date: 2019-8-18 20:04
 * @Version: 1.0
 */
public class ArrayTest {

    @Test
    public void array(){
        Array array = new Array(10);
        array.insert(3,0);
        array.insert(2,1);
        array.insert(5,2);
        array.insert(6,3);
        array.insert(7,1);
        array.add(9);
        Assert.assertEquals(array.get(3),5);

    }
}
