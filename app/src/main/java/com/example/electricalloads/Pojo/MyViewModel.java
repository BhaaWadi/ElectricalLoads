package com.example.electricalloads.Pojo;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.electricalloads.Interface.ElectricConverterListener;
import com.example.electricalloads.Interface.MeasurementListener;

import java.util.ArrayList;
import java.util.List;

public class MyViewModel extends AndroidViewModel {

    Repository repository;


    LiveData<List<ElectricConverter>>  ElectricConverterLiveData;
    LiveData<List<Reading>> ReadingLiveData ;

    public MyViewModel(@NonNull Application application) {
        super(application);
        repository=new Repository();
    }



    public void  getAllElectricConverter(Context context, ElectricConverterListener electricConverterListener) {

         repository.getAllElectricConverter(context, electricConverterListener);


    }

    public  void  getReadingByElectricConverterID(int ElectricConverterID, Context context, ReadingListener readingListener){


        repository.getReadingByElectricConverterID(ElectricConverterID,context,readingListener);





    }

    public void  addMeasurement(ArrayList<Reading> readingArrayList, MeasurementListener listener){


        repository.addMeasurement(readingArrayList,listener);

    }









}
