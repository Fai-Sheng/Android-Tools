package com.fai.tools.model;

import com.fai.autoassignment.annotations.EntityParam;
import com.fai.autoassignment.annotations.Param;

/**
 * Created by PVer on 2018/6/11.
 */

public class Person {
    public String name;
    @Param(name = "xxyy")
    public int age;
    @Param(name = "sexsex")
    public String sex;
    @Param(name = "mCareer")
    public String career;
    @Param(name = "a")
    public W w;

    @EntityParam(name = "W")
    public static class W {
        public X x;

        @EntityParam(name = "X")
        public static class X{

            public Y y;

            @EntityParam(name = "Y")
            public static class Y{


                public Z z;
                @EntityParam(name = "Z")
                public static class Z{

                    @Param(name = "love")
                    public String deepTree;
                }
            }
        }
    }

}
