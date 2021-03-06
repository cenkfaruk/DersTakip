package com.example.cenk.derstakip.Objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Cenk Faruk Cavga on 21.01.2018.
 */

public class Topic implements Parcelable {
    int id;
    String name;
    String description;
    String topicUrl;

    public Topic(int id, String name, String description,String topicUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.topicUrl=topicUrl;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTopicUrl() {
        return topicUrl;
    }

    public void setTopicUrl(String topicUrl) {
        this.topicUrl = topicUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(topicUrl);
    }

    private Topic(Parcel in){
        id=in.readInt();
        name=in.readString();
        description=in.readString();
        topicUrl=in.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Topic createFromParcel(Parcel in) {
            return new Topic(in);
        }
        public Topic[] newArray(int size) {
            return new Topic[size];
        }
    };
}
