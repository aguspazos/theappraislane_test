package com.agustinpazos.hrviewer.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Name {

    @SerializedName("first")
    @Expose
    public String first_name;

    @SerializedName("last")
    @Expose
    public String last;
}
