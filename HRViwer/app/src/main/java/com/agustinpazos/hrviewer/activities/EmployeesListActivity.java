package com.agustinpazos.hrviewer.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.agustinpazos.hrviewer.R;
import com.agustinpazos.hrviewer.adapters.EmployerAdapter;
import com.agustinpazos.hrviewer.databinding.ActivityEmployeesListBinding;
import com.agustinpazos.hrviewer.models.Employee;
import com.agustinpazos.hrviewer.models.EmployeesRepository;
import com.agustinpazos.hrviewer.viewmodels.EmployeesListViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EmployeesListActivity extends AppCompatActivity {



    private List<Employee> employees;
    private RecyclerView recyclerView;
    private EmployerAdapter employerAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private EmployeesListViewModel mainActivityViewModel;
    private ActivityEmployeesListBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees_list);
        ButterKnife.bind(this);
        EmployeesRepository repository = new EmployeesRepository(getApplication());

        getSupportActionBar().setTitle("EMPLOYEES!!");

        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_employees_list);

        mainActivityViewModel= ViewModelProviders.of(this).get(EmployeesListViewModel.class);

        getEmployees();


        swipeRefreshLayout = activityMainBinding.swipeLayout;
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                getEmployees();

            }
        });
    }

    public void getEmployees() {

        mainActivityViewModel.getAllEmployees().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(@Nullable List<Employee> employeesFromLiveData) {
                employees =  employeesFromLiveData;
                showOnRecyclerView();
            }
        });


    }

    private void showOnRecyclerView() {

        recyclerView = activityMainBinding.employeesRecyclerView;
        employerAdapter = new EmployerAdapter(employees, this);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(employerAdapter);
        employerAdapter.notifyDataSetChanged();

    }


}
