package com.agustinpazos.hrviewer.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;

import com.agustinpazos.hrviewer.BR;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;


public class Employee extends BaseObservable {

    @SerializedName("login")
    @Expose
    private LoginInfo loginInfo;


    @SerializedName("name")
    @Expose
    private Name name;



    @SerializedName("picture")
    @Expose
    private Picture picture;


    @SerializedName("dob")
    @Expose
    private DateOfBirth dateOfBirth;

    @SerializedName("email")
    @Expose
    private String emailAddress;

    @SerializedName("phone")
    @Expose
    private String phoneNumber;

//    @SerializedName("address")
//    @Expose
//    private String address;


    public Employee(){

    }
//
//    @Bindable
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//        notifyPropertyChanged(BR.id);
//    }
//

    @Bindable
    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
        notifyPropertyChanged(BR.picture);
    }
//
//    @Bindable
//    public String getPictureThumb() {
//        return pictureThumb;
//    }
//
//    public void setPictureThumb(String pictureThumb) {
//        this.pictureThumb = pictureThumb;
//        notifyPropertyChanged(BR.pictureThumb);
//    }
//
//    @Bindable
//    public String getFullName() {
//        return fullName;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//        notifyPropertyChanged(BR.fullName);
//    }

    @Bindable
    public String getBirthDate() {
//        return birthDate;
        return  dateOfBirth.date;
    }

    public void setBirthDate(String birthDate) {
//        this.birthDate = birthDate;
//        notifyPropertyChanged(BR.birthDate);
    }

    @Bindable
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        notifyPropertyChanged(BR.emailAddress);
    }

    @Bindable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        notifyPropertyChanged(BR.phoneNumber);
    }

//    @Bindable
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//        notifyPropertyChanged(BR.address);
//    }
//
//    @Bindable
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//        notifyPropertyChanged(BR.username);
//    }
//
//    @Bindable
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//        notifyPropertyChanged(BR.password);
//    }


    @Bindable
    public String getFullName(){
        return name.first_name + " "+name.last;
    }

    @Bindable
    public String getMediumPicture(){
        return picture.medium;
    }
    @BindingAdapter({"mediumPicture"})
    public static void loadImage(ImageView imageView,String imageURL){

        if(!imageURL.equals("")) {
            Picasso.with(imageView.getContext()).load(imageURL).into(imageView);
        }
    }
}
