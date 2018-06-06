package com.fai.autoassignment.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by PVer on 2018/6/4.
 */

@Target(ElementType.FIELD)
public @interface EntityParam {
    String name();
}
