package com.fai.autoassignment.imp;

import com.fai.autoassignment.core.Resolver;

/**
 * Created by PVer on 2018/6/4.
 */

public class FieldResolver implements Resolver{


    @Override
    public <T, K> K execSetParam(T src, K goal) {
        return null;
    }


    // 1.两个相同的CParam 的name值
    // 2.只有goal上面有 name值
    // 3.两个字段上面都没有值

    // 4.存在内部类对象 的情况如何处理
    // 5.内部类的对象 的值 赋值给一个goal的普通值
}
