package com.example.spiski5;

import android.os.Parcel;
import android.os.Parcelable;

public class Good implements Parcelable{
    private int id;
    private String name;
    private boolean check;

    public Good(int id, String name, boolean check) {
        this.id = id;
        this.name = name;
        this.check = check;
    }

    public int getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public boolean isCheck() {
        return check;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    @Override
    public int describeContents() {

        return 0;
    }

    // упаковываем объект в Parcel
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
    }

    // конструктор, считывающий данные из Parcel
    private Good(Parcel parcel) {
        id = parcel.readInt();
        name = parcel.readString();
        check = false;
    }

    public static final Parcelable.Creator<Good> CREATOR = new Parcelable.Creator<Good>() {
        // распаковываем объект из Parcel
        public Good createFromParcel(Parcel in) {

            return new Good(in);
        }

        public Good[] newArray(int size) {

            return new Good[size];
        }
    };
}
