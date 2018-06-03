package com.fai.tools.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.List;

/**
 * Created by PVer on 2018/6/1.
 */

public class ParcelData implements Parcelable{

    public String name;
    public String carrer;
    public String introduction;
    public int age;
    public boolean isGirl;
    public List<Friend> listFriends;
    public HashMap<String,String> dreamMap;

    public ParcelData(String name,String career,String introduction,int age,boolean isGirl,List<Friend> listFriends,HashMap<String,String> hashMap)
    {
        this.name = name;
        this.carrer = career;
        this.introduction = introduction;
        this.age = age;
    }

    protected ParcelData(Parcel in) {
        name = in.readString();
        carrer = in.readString();
        introduction = in.readString();
        age = in.readInt();
        isGirl = in.readByte() != 0;
        listFriends = in.createTypedArrayList(Friend.CREATOR);
    }

    public static final Creator<ParcelData> CREATOR = new Creator<ParcelData>() {
        @Override
        public ParcelData createFromParcel(Parcel in) {
            return new ParcelData(in);
        }

        @Override
        public ParcelData[] newArray(int size) {
            return new ParcelData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(carrer);
        dest.writeString(introduction);
        dest.writeInt(age);
        dest.writeByte((byte) (isGirl ? 1 : 0));
        dest.writeTypedList(listFriends);
    }


}
