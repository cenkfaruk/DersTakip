package com.example.cenk.derstakip.Objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Cenk Faruk Cavga on 21.01.2018.
 */

public class Instructor implements Parcelable {
    private int id;
    private String name;
    private String surname;
    private String department;
    private String photoUrl;

    public Instructor(int id, String name, String surname, String department, String photoUrl) {
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.photoUrl = photoUrl;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhoto() {
        return photoUrl;
    }

    public void setPhoto(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        dest.writeString(department);
        dest.writeString(photoUrl);
    }

    private Instructor(Parcel in){
        id=in.readInt();
        name=in.readString();
        surname=in.readString();
        department=in.readString();
        photoUrl=in.readString();
    }



    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Instructor createFromParcel(Parcel in) {
            return new Instructor(in);
        }
        public Instructor[] newArray(int size) {
            return new Instructor[size];
        }
    };
}
