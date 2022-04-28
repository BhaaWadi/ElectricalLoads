package com.example.electricalloads.Pojo;

import android.content.Context;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.example.electricalloads.Interface.API_Interface;
import com.example.electricalloads.Interface.ElectricConverterListener;
import com.example.electricalloads.Interface.MeasurementListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    API_Interface apiInterface;

    public Repository() {
        this.apiInterface = apiInterface;
        apiInterface = APIClient.getClient().create(API_Interface.class);

    }

    public void  getAllElectricConverter(Context context, ElectricConverterListener  electricConverterListener) {
        apiInterface.getAllElectricConverter().enqueue(new Callback<List<ElectricConverter>>() {
            @Override
            public void onResponse(Call<List<ElectricConverter>> call, Response<List<ElectricConverter>> response) {

                List<ElectricConverter> list = response.body();

                electricConverterListener.getAllElectricConverterListener(list);


            }

            @Override
            public void onFailure(Call<List<ElectricConverter>> call, Throwable t) {

                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    public  void  getReadingByElectricConverterID(int electricConverterID, Context context, ReadingListener readingListener){



        apiInterface.getReadingByElectricConverterID(String.valueOf(electricConverterID)).enqueue(new Callback<ReadingResponse>() {
            @Override
            public void onResponse(Call<ReadingResponse> call, Response<ReadingResponse> response) {


                ReadingResponse readingResponse=    response.body();
                readingListener.getReadingByElectricConverterID(readingResponse.getReadingArrayList(),
                        readingResponse.getPercentageFaz()
                        ,readingResponse.getAverage_loading_percentage());
            }

            @Override
            public void onFailure(Call<ReadingResponse> call, Throwable t) {

            }
        });


    }




    public void  addMeasurement(ArrayList<Reading>readingArrayList, MeasurementListener listener){


        apiInterface.addMeasurement(readingArrayList).enqueue(new Callback<MeasurementResponse>() {
            @Override
            public void onResponse(Call<MeasurementResponse> call, Response<MeasurementResponse> response) {

               listener .getStatusCode(response.body().getStatusCode());

            }

            @Override
            public void onFailure(Call<MeasurementResponse> call, Throwable t) {
                listener.getStatusCode(0);

            }
        });
    }



    }

