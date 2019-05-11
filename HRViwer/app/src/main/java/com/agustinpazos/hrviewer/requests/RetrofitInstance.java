package com.agustinpazos.hrviewer.requests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by K. A. ANUSHKA MADUSANKA on 7/9/2018.
 */
public class RetrofitInstance {

    private static Retrofit retrofit = null;
    private static String BASE_URL="https://randomuser.me/";

    public static EmployeesDataService getService(){


        if(retrofit==null){

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
               retrofit=new Retrofit
                       .Builder()
                       .baseUrl(BASE_URL)
                       .addConverterFactory(GsonConverterFactory.create(gson))
                       .build();

        }

        return retrofit.create(EmployeesDataService.class);

    }

}
