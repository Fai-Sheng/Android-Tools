package com.fai.tools.model;

/**
 * Created by PVer on 2018/6/11.
 */

public class User {

    public String name;
    public int age;
    public String carrer;
    public Family family;
    public XXX x;

    public static class Family{
        public String mother;
        public String father;
        public String grandMom;
        public String grandPa;
    }

    public static class XXX{
        public String xxx;
        public String yyy;
        public String zzz;
        public String ttt;
        public HHH h;

        public static class HHH{
            public String qqq;
            public String ooo;
            public String ccc;
        }
    }
}

