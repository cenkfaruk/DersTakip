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
    private String password;
    private String tckn;

    public Student(int id, String name, String surname, double number, String password,String tckn) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.password=password;
        this.tckn=tckn;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTckn() {
        return tckn;
    }

    public void setTckn(String tckn) {
        this.tckn = tckn;
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
        dest.writeString(password);
        dest.writeString(tckn);



    }

    private Student(Parcel in){
        id=in.readInt();
        name=in.readString();
        surname=in.readString();
        number=in.readDouble();
        password=in.readString();
        tckn=in.readString();

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
