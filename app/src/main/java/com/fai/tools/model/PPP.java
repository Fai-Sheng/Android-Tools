package com.fai.tools.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by PVer on 2018/6/10.
 */

@Target(ElementType.TYPE)
public @interface PPP {
    String name() default "";
}
