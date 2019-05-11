package com.agustinpazos.hrviewer.models;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.agustinpazos.hrviewer.R;
import com.agustinpazos.hrviewer.Utils.Constants;
import com.agustinpazos.hrviewer.requests.EmployeesDataService;
import com.agustinpazos.hrviewer.requests.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeesRepository {

    private MutableLiveData<List<Employee>> mutableLiveData=new MutableLiveData<>();
    private Application application;

    public EmployeesRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Employee>> getEmployees() {

        EmployeesDataService movieDataService = RetrofitInstance.getService();

        Call<EmployeeResponse> call = movieDataService.getAllEmployees(Constants.EMPLOYEES_PAGING);
        call.enqueue(new Callback<EmployeeResponse>() {
            @Override
            public void onResponse(Call<EmployeeResponse> call, Response<EmployeeResponse> response) {
                EmployeeResponse employees = response.body();
                if (employees != null && employees.employees != null) {
                    mutableLiveData.setValue(employees.employees);
                }else{
                    mutableLiveData.setValue(new ArrayList<Employee>());
                }
            }

            @Override
            public void onFailure(Call<EmployeeResponse> call, Throwable t) {
                Log.d("err",t.getMessage());
            }
        });

        return mutableLiveData;
    }
}
