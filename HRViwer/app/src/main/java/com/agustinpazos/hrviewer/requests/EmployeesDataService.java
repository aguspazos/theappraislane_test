package com.agustinpazos.hrviewer.requests;


import com.agustinpazos.hrviewer.models.Employee;
import com.agustinpazos.hrviewer.models.EmployeeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface EmployeesDataService {


    @GET("api")
    Call<EmployeeResponse> getAllEmployees(@Query("results") int apiKey);


}
