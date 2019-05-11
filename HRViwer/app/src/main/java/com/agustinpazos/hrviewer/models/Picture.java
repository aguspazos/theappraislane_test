package com.agustinpazos.hrviewer.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Picture {
    @SerializedName("medium")
    @Expose
    public String medium;

    @SerializedName("large")
    @Expose
    public String large;

    @SerializedName("thumbnail")
    @Expose
    public String thumbnail;
}
