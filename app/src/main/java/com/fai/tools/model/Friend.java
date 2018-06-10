package com.fai.tools.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import java.util.Set;

/**
 * Created by PVer on 2018/6/1.
 */

public class Friend implements Parcelable{

    public String name;
    public Integer integer;
    public Set<String> set;
    public int age;
    public int apples;
    public String career;
    public List<String> flowerList;
    int[] ints;

    public Friend()
    {

    }

    protected Friend(Parcel in) {
        name = in.readString();
        age = in.readInt();
        apples = in.readInt();
        career = in.readString();
        flowerList = in.createStringArrayList();
    }

    public static final Creator<Friend> CREATOR = new Creator<Friend>() {
        @Override
        public Friend createFromParcel(Parcel in) {
            return new Friend(in);
        }

        @Override
        public Friend[] newArray(int size) {
            return new Friend[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeInt(apples);
        dest.writeString(career);
        dest.writeStringList(flowerList);
    }
}
