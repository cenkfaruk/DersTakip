package com.example.cenk.derstakip.Objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Cenk Faruk Cavga on 21.01.2018.
 */

public class Student implements Parcelable {
    private int id;
    private String name;
    private String surname;
    private double number;
    private String photoUrl;

    public Student(int id, String name, String surname, double number) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(surname);
        dest.writeDouble(number);


    }

    private Student(Parcel in){
        id=in.readInt();
        name=in.readString();
        surname=in.readString();
        number=in.readDouble();

    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
