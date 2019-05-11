package com.agustinpazos.hrviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.agustinpazos.hrviewer.Utils.Constants;
import com.agustinpazos.hrviewer.activities.EmployeesListActivity;
import com.agustinpazos.hrviewer.models.Employee;
import com.agustinpazos.hrviewer.models.EmployeeResponse;
import com.agustinpazos.hrviewer.models.EmployeesRepository;
import com.agustinpazos.hrviewer.requests.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, EmployeesListActivity.class);
        startActivity(intent);


    }
}
