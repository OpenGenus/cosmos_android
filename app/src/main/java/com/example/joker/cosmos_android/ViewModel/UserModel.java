package com.example.joker.cosmos_android.ViewModel;

public class UserModel {

    String id,name,email,imgURL;

    public UserModel(String id, String name, String email, String imgURL) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.imgURL = imgURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
    @Override
    public String toString() {
        return (getName() + " " + getEmail() + " " + getImgURL());
    }
}
