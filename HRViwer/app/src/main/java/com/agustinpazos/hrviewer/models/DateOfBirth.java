package com.agustinpazos.hrviewer.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DateOfBirth {

    @SerializedName("date")
    @Expose
    public String date;
}
