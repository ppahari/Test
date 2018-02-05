package com.example.realnapster.test;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Realnapster on 2/5/2018.
 */

public class ListItem implements Parcelable {
    int title;
    int subtitle;
    int imageRes;

    public ListItem(int title, int subtitle, int imageRes) {
        this.title = title;
        this.subtitle = subtitle;
        this.imageRes = imageRes;
    }

    public int getTitle() {
        return this.title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getSubtitle() {
        return this.subtitle;
    }

    public void setSubtitle(int subtitle) {
        this.subtitle = subtitle;
    }

    public int getImageRes() {
        return this.imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.title);
        dest.writeInt(this.subtitle);
        dest.writeInt(this.imageRes);
    }

    protected ListItem(Parcel in) {
        this.title = in.readInt();
        this.subtitle = in.readInt();
        this.imageRes = in.readInt();
    }

    public static final Parcelable.Creator<ListItem> CREATOR = new Parcelable.Creator<ListItem>() {
        @Override
        public ListItem createFromParcel(Parcel source) {
            return new ListItem(source);
        }

        @Override
        public ListItem[] newArray(int size) {
            return new ListItem[size];
        }
    };
}
