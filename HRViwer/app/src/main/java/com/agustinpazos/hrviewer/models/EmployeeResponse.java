package com.agustinpazos.hrviewer.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeeResponse {

    @SerializedName("results")
    @Expose
    public List<Employee> employees ;


}
