package com.example.electricalloads.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.electricalloads.Interface.ElectricConverterListener;
import com.example.electricalloads.Pojo.ElectricConverter;
import com.example.electricalloads.Pojo.MyViewModel;
import com.example.electricalloads.R;
import com.example.electricalloads.adapter.ElectricConverterAdapter;
import com.example.electricalloads.databinding.ActivityHomeBinding;
import com.example.electricalloads.databinding.CustomItemHomeActivityBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    MyViewModel myViewModel;
    public static final String ElectricConverter_KEY = "ElectricConverter";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myViewModel= new ViewModelProvider(this).get(MyViewModel.class);

        if(!isNetworkConnected()){
            showMessageError("لا يوجد اتصال بالإنترنت");

        }
        else {


            //getAllElectricConverter from Api

//            myViewModel.getAllElectricConverter(this, new ElectricConverterListener() {
//                @Override
//                public void getAllElectricConverterListener(List<ElectricConverter> list) {
//                    binding.progressBar.setVisibility(View.GONE);
//
//                    setUpRecyclerView(list);
//                }
//            });

//
           binding.progressBar.setVisibility(View.GONE);
            ArrayList<ElectricConverter>list=new ArrayList<>();

            //todo you must delete below to equip api
            /// simple Data Test
            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();
            ////
            list.add(new ElectricConverter(1,"صبحة الحرازين",
                    "محافظةغزة",date,950,"بيدكو",
                    2020,8,9,
                    33000,"الرمال",
                    88.94,78.22
                    ,"المواطنين"));
            list.add(new ElectricConverter(1,"صبحة الحرازين",
                    "محافظةغزة",date,950,"بيدكو",
                    2020,8,9,
                    33000,"الرمال",
                    88.94,78.22
                    ,"المواطنين"));
            list.add(new ElectricConverter(1,"صبحة الحرازين",
                    "محافظةغزة",date,950,"بيدكو",
                    2020,8,9,
                    33000,"الرمال",
                    88.94,78.22
                    ,"المواطنين"));
            list.add(new ElectricConverter(1,"صبحة الحرازين",
                    "محافظةغزة",date,950,"بيدكو",
                    2020,8,9,
                    33000,"الرمال",
                    88.94,78.22
                    ,"المواطنين"));
            list.add(new ElectricConverter(1,"صبحة الحرازين",
                    "محافظةغزة",date,950,"بيدكو",
                    2020,8,9,
                    33000,"الرمال",
                    88.94,78.22
                    ,"المواطنين"));
            list.add(new ElectricConverter(1,"صبحة الحرازين",
                    "محافظةغزة",date,950,"بيدكو",
                    2020,8,9,
                    33000,"الرمال",
                    88.94,78.22
                    ,"المواطنين"));

            ///end
            setUpRecyclerView(list);

        }












    }

    public void setUpRecyclerView(List<ElectricConverter> list) {

        ElectricConverterAdapter adapter = new ElectricConverterAdapter(list, this);

        adapter.setListener(new ElectricConverterAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ElectricConverter i) {
                Intent intent = new Intent(getBaseContext(), DetailsActivity.class);
                intent.putExtra(ElectricConverter_KEY, i);
                startActivity(intent);
            }
        });


        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        binding.recyclerView.setHasFixedSize(true);

    }






    private void showMessageError(String massage) {

        Toasty.error(getBaseContext(), massage, Toast.LENGTH_SHORT, true).show();

    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}