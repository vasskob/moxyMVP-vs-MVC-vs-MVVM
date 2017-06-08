package com.task.vasskob.testarchitect.model;

public class User {
    private int userID;
    private String name;
    private String avatarURL;

    public User(int userID, String name, String avatarURL) {
        this.userID = userID;
        this.name = name;
        this.avatarURL = avatarURL;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", name='" + name + '\'' +
                ", avatarURL='" + avatarURL + '\'' + '}';
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }
}
