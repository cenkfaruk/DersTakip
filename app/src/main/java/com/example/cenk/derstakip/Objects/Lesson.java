package com.example.cenk.derstakip.Objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Cenk Faruk Cavga on 21.01.2018.
 */

public class Lesson implements Parcelable {
    private int id;
    private String name;
    private Instructor instructor;
    private int progress;
    private String recentPages;
    private Topic recentTopic;

    public Lesson(int id, String name, Instructor instructor, int progress, String recentPages,Topic recentTopic) {
        this.id = id;
        this.name = name;
        this.instructor = instructor;
        this.progress= progress;
        this.recentPages=recentPages;
        this.recentTopic=recentTopic;
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

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getRecentPages() {
        return recentPages;
    }

    public void setRecentPages(String recentPages) {
        this.recentPages = recentPages;
    }

    public Topic getRecentTopic() {
        return recentTopic;
    }

    public void setRecentTopic(Topic recentTopic) {
        this.recentTopic = recentTopic;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeParcelable(instructor,flags);
        dest.writeInt(progress);
        dest.writeString(recentPages);
        dest.writeParcelable(recentTopic,flags);
    }

    private Lesson(Parcel in){
        id=in.readInt();
        name=in.readString();
        instructor=in.readParcelable(Instructor.class.getClassLoader());
        progress=in.readInt();
        recentPages=in.readString();
        recentTopic=in.readParcelable(Topic.class.getClassLoader());
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Lesson createFromParcel(Parcel in) {
            return new Lesson(in);
        }
        public Lesson[] newArray(int size) {
            return new Lesson[size];
        }
    };
}
