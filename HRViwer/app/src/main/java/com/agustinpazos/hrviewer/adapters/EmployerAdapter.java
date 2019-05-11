package com.agustinpazos.hrviewer.adapters;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.agustinpazos.hrviewer.R;
import com.agustinpazos.hrviewer.databinding.EmployeeItemBinding;
import com.agustinpazos.hrviewer.models.Employee;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EmployerAdapter extends RecyclerView.Adapter<EmployerAdapter.EmployeeViewHolder> {

    private static final String TAG = EmployerAdapter.class.getSimpleName();
    private List<Employee> mData = new ArrayList<>();
    private Context mContext;

    public EmployerAdapter(List<Employee> mData, Context context) {
        this.mData = mData;
        this.mContext = context;
    }

    @Override
    public EmployerAdapter.EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        EmployeeItemBinding employeeItemBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
                ,R.layout.employee_item,parent,true);

        return new EmployeeViewHolder(employeeItemBinding);
    }

    @Override
        public void onBindViewHolder(EmployerAdapter.EmployeeViewHolder holder, int position) {
        Employee employee=mData.get(position);
        holder.employeeItemBinding.birthDate.setText(employee.getBirthDate());
        holder.employeeItemBinding.fullName.setText(employee.getFullName());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {
        private EmployeeItemBinding employeeItemBinding;


        public EmployeeViewHolder(@NonNull EmployeeItemBinding employeeItemBinding) {
            super(employeeItemBinding.getRoot());
            this.employeeItemBinding=employeeItemBinding;
            employeeItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position=getAdapterPosition();

                    if(position!=RecyclerView.NO_POSITION) {

                        Employee selctedMovie = mData.get(position);

                    }


                }
            });


        }
    }

}
