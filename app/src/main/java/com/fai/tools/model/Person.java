package com.fai.tools.model;

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
    @Param(fromEntityField = {"a","b","c","d","love"})
    public String deep;

    public static class W {
        @Param(name = "b")
        public X x;

        public static class X{
            @Param(name = "c")
            public Y y;

            public static class Y{
                @Param(name = "d")
                public Z z;
                public static class Z{

                    @Param(name = "love")
                    public String deepTree;
                }
            }
        }
    }

}
