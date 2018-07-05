package com.fai.tools.model;

import com.fai.autoassignment.annotations.EntityParam;
import com.fai.autoassignment.annotations.Param;

import retrofit2.http.FormUrlEncoded;

/**
 * Created by PVer on 2018/6/11.
 */

public class User {

    private String name;
    @Param(name = "xxyy")
    private int mAge;
    private String mCareer;
    @Param(name = "sexsex")
    private String mSex;

    public A a;

    @EntityParam(name = "W")
    public static class A {
        public B b;
        @EntityParam(name = "X")
        public static class B{
            public C c;
            @EntityParam(name = "Y")
            public static  class C{
                public D d;
                @EntityParam(name = "Z")
                public static class D{
                    public String love;
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getmAge() {
        return mAge;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }

    public String getmCareer() {
        return mCareer;
    }

    public void setmCareer(String mCareer) {
        this.mCareer = mCareer;
    }

    public String getmSex() {
        return mSex;
    }

    public void setmSex(String mSex) {
        this.mSex = mSex;
    }



}

