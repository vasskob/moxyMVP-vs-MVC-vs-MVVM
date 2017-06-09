package com.task.vasskob.testarchitect.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.task.vasskob.testarchitect.BR;

public class UserMVVM extends BaseObservable implements Parcelable {
    private int userID;
    private String name;
    private String avatarURL;

    public UserMVVM(int userID, String name, String avatarURL) {
        this.userID = userID;
        this.name = name;
        this.avatarURL = avatarURL;
    }

    public UserMVVM() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", name='" + name + '\'' +
                ", avatarURL='" + avatarURL + '\'' + '}';
    }

    @Bindable
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
        notifyPropertyChanged(BR.userID);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
        notifyPropertyChanged(BR.avatarURL);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.userID);
        dest.writeString(this.name);
        dest.writeString(this.avatarURL);
    }

    protected UserMVVM(Parcel in) {
        this.userID = in.readInt();
        this.name = in.readString();
        this.avatarURL = in.readString();
    }

    public static final Parcelable.Creator<UserMVVM> CREATOR = new Parcelable.Creator<UserMVVM>() {
        @Override
        public UserMVVM createFromParcel(Parcel source) {
            return new UserMVVM(source);
        }

        @Override
        public UserMVVM[] newArray(int size) {
            return new UserMVVM[size];
        }
    };
}
