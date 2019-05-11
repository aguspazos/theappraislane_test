package com.agustinpazos.hrviewer.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.agustinpazos.hrviewer.models.Employee;
import com.agustinpazos.hrviewer.models.EmployeesRepository;

import java.util.List;

public class EmployeesListViewModel extends AndroidViewModel {
    private EmployeesRepository employeesRepository;

    public EmployeesListViewModel(@NonNull Application application) {
        super(application);
        employeesRepository=new EmployeesRepository(application);
    }

    public LiveData<List<Employee>> getAllEmployees(){

        return employeesRepository.getEmployees();
    }
}
