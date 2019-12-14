package com.lhj.base;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.system.JavaInfo;
import org.junit.Test;

/**
 * @ProjectName: java-base
 * @Package: com.base.test
 * @ClassName: HutoolTest
 * @Author: LiAy
 * @Description: $END$
 * @Date: 2019-9-2 15:30
 * @Version: 1.0
 */
public class HutoolTest {

    @Test
    public void test(){
        String md5 = "lhj";
        String s = SecureUtil.md5(md5);
        System.out.println(s);
        System.out.println( new JavaInfo().getVersion());
    }
}
