package com.example.electricalloads.Interface;


import com.example.electricalloads.Pojo.ElectricConverter;
import com.example.electricalloads.Pojo.MeasurementResponse;
import com.example.electricalloads.Pojo.Reading;
import com.example.electricalloads.Pojo.ReadingResponse;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface API_Interface {

    //هو عبارة عن الريسيونس الذي يأتي من السيرفر
    // لاحظ أيضا يا كبير الملامح انو كلاس call ده موجود في مكتبة retrofit

    @GET("")
    Call<List<ElectricConverter>>getAllElectricConverter();

    @GET("/?")
    Call<ReadingResponse>getReadingByElectricConverterID(@Query("id_ElectricConverter") String electricConverterID);

    @POST("/")
        //{@Body} : body ده علشان يفهم انو سيتم ارسال الاوبجكت(البيانات) في
    Call<MeasurementResponse>addMeasurement(@Body ArrayList<Reading> readingArrayList);





}
