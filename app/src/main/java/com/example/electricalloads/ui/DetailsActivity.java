package com.example.electricalloads.ui;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.electricalloads.Interface.ElectricConverterListener;
import com.example.electricalloads.Pojo.ElectricConverter;
import com.example.electricalloads.Pojo.MyViewModel;
import com.example.electricalloads.Pojo.Reading;
import com.example.electricalloads.Pojo.ReadingListener;
import com.example.electricalloads.Pojo.ReadingResponse;
import com.example.electricalloads.R;
import com.example.electricalloads.adapter.ElectricConverterAdapter;
import com.example.electricalloads.adapter.ReadingAdapter;
import com.example.electricalloads.databinding.ActivityDetailsBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class DetailsActivity extends AppCompatActivity {

    ActivityDetailsBinding binding;
    MyViewModel myViewModel;
    int electricConverterID;
    public static final String ElectricConverterID_KEY="Key";
    ReadingAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myViewModel= new ViewModelProvider(this).get(MyViewModel.class);


        ElectricConverter electricConverter= (ElectricConverter) getIntent().getExtras().getSerializable(HomeActivity.ElectricConverter_KEY);
         electricConverterID=electricConverter.getId_material();
        AssignValueToFields(electricConverter);


        AssignValueToFields(electricConverter);


        if(!isNetworkConnected()){
            showMessageError("لا يوجد اتصال بالإنترنت");

        }
        else {



            // getData from Api
            //ToDo must uncomment to equip api
            //getLastMeasurement();


            binding.progressBar.setVisibility(View.GONE);
            ///Test data
            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();

            ArrayList<Reading>list=new ArrayList<>();
            list.add(new Reading(1,1,2,400,200,300,600,
                    500,200,150,650,470,100,140,1,date.getTime()));
            list.add(new Reading(1,1,2,400,200,300,600,
                    500,200,150,650,470,100,140,1,date.getTime()));
            list.add(new Reading(1,1,2,400,200,300,600,
                    500,200,150,650,470,100,140,1,date.getTime()));
            list.add(new Reading(1,1,2,400,200,300,600,
                    500,200,150,650,470,100,140,1,date.getTime()));
            setUpRecyclerView(list);



        }


        ActivityResultLauncher<Intent> arl = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {

                if (result.getResultCode() == RESULT_OK && result.getData() != null) {

                    ArrayList<Reading> readingArrayList = (ArrayList<Reading>) result.getData().getSerializableExtra(NewSizeActivity.READING_LIST_KEY);

                    if(readingArrayList!=null&&readingArrayList.size()>0) {


                        setUpRecyclerView(readingArrayList);
                        adapter.notifyDataSetChanged();
                    }


                }

            }
        });


        binding.textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


              //the one first solution

//                Intent intent=new Intent(getBaseContext(),NewSizeActivity.class);
//                arl.launch(intent);

                //the two solution

                Intent intent=new Intent(getBaseContext(),NewSizeActivity.class);
                intent.putExtra(ElectricConverterID_KEY,electricConverterID);

                startActivity(intent);
               }
        });






    }




    public void setUpRecyclerView(List<Reading> list) {

         adapter = new ReadingAdapter(list, this);
        binding.rec.setAdapter(adapter);
        binding.rec.setLayoutManager(new LinearLayoutManager(this));
        binding.rec.setHasFixedSize(true);

    }









    private void AssignValueToFields(ElectricConverter electricConverter) {


        binding.textNumber.setText(String.valueOf(electricConverter.getId_material()));
        binding.textGovernorate.setText(electricConverter.getGovernorate());
        binding.textAdapterName.setText(electricConverter.getConverterName());
        binding.textAdapterCapacity.setText(String.valueOf(electricConverter.getAdapter_capacity()));
        binding.textAdapterCapacity.setText(String.valueOf(electricConverter.getAdapter_capacity()));
        binding.textCompanyName.setText(electricConverter.getCompany_name());
        binding.textAdapterResistance.setText(String.valueOf(electricConverter.getAdapter_capacity()));
        binding.textManufacturing.setText(String.valueOf(electricConverter.getManufacturing()));
        binding.textPower.setText(String.valueOf(electricConverter.getPower()));
        binding.textCurrentPower.setText(String.valueOf(electricConverter.getCurrent_power()));
        binding.textCurrentVoltage.setText(String.valueOf(electricConverter.getCurrent_voltage()));
        binding.textFeedLine.setText(electricConverter.getFeed_line());
        binding.textDownloadHighestBeat.setText(String.valueOf(electricConverter.getPercentageFAz()));
        binding.textLoadAverage.setText(String.valueOf(electricConverter.getPercentageAvg()));
        binding.textLoadAverage.setText(String.valueOf(electricConverter.getPercentageAvg()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dateFormat.format(electricConverter.getLastReadDate());
        binding.textMeasurementDate.setText(strDate);
        binding.textNatureOfAdapterLoads.setText(electricConverter.getNature_of_adapter_loads());

    }








    private void showMessageError(String massage) {

        Toasty.error(getBaseContext(), massage, Toast.LENGTH_SHORT, true).show();

    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    private void getLastMeasurement(){

        myViewModel.getReadingByElectricConverterID(electricConverterID, this, new ReadingListener() {
            @Override
            public void getReadingByElectricConverterID(List<Reading> list, double percentageFaz, double average_loading_percentage) {

                binding.progressBar.setVisibility(View.GONE);
                setUpRecyclerView(list);

                //show filed percentageFaz ,average_loading_percentage
                binding.layoutAverageLoadingPercentage.setVisibility(View.VISIBLE);
                binding.layoutPercentageFAz.setVisibility(View.VISIBLE);

                binding.percentageFAz.setText(String.valueOf(percentageFaz));
                binding.averageLoadingPercentage.setText(String.valueOf(average_loading_percentage));
            }
        });



        }


    @Override
    protected void onRestart() {
        super.onRestart();

        //ToDo must uncomment to equip api
       // getLastMeasurement();
    }
}