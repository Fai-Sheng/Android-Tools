package com.fai.tools.model;

import com.fai.autoassignment.annotations.EntityParam;
import com.fai.autoassignment.annotations.Param;

/**
 * Created by PVer on 2018/6/11.
 */

public class Person {
    @Param(name = "career")
    public String name;
    public Jia jia;
    public YYY y;
    @Param(fromEntityField = {"x","zzz"})
    public String deepGet;
    @Param(name = "array")
    public XTXT[] array;

    public static class XTXT{
        public String name;
    }

    @EntityParam(name = "Family")
    public static class Jia {
        public String father;
        public String mother;
    }

    @EntityParam(name = "XXX")
    public static class YYY{
        @Param(name = "xxx")
        public String iii;
        @Param(name = "yyy")
        public String jjj;
        public OLOL olol;

        @EntityParam(name = "HHH")
        public static class OLOL{
            @Param(name = "qqq")
            public String lll;
            @Param(name = "ooo")
            public String mmm;
        }
    }
}
