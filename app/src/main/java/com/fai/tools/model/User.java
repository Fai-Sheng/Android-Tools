package com.fai.tools.model;

import java.util.List;

/**
 * Created by PVer on 2018/6/11.
 */

public class User {

    public String name;
    public int age;
    public String career;
    public Family family;
    public XXX x;
    public TTT[] array;
    public List<XXX> list;

    public static class Family{
        public String mother;
        public String father;
        public String grandMom;
        public String grandPa;
    }

    public static class TTT {
        public String name;
        public int id;
        public String lll;
        public String xxx;
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

