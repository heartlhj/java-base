package com.base.test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ProjectName: java-base
 * @Package: com.base.test
 * @ClassName: Test
 * @Author: LiAy
 * @Description: $END$
 * @Date: 2019-8-27 19:47
 * @Version: 1.0
 */
public class LockTest {

    public static void main(String[] args){
        ReentrantLock reentrantLock = new ReentrantLock();
        for (int i = 0; i < 1000; i++) {
            System.out.println("TEST LOCK!");
        }
    }
}
