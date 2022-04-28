package com.example.electricalloads.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.electricalloads.Pojo.MyViewModel;
import com.example.electricalloads.Pojo.Reading;
import com.example.electricalloads.adapter.ReadingAdapter;
import com.example.electricalloads.databinding.ActivityNewSizeBinding;
import com.example.electricalloads.databinding.CustomDialogBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class NewSizeActivity extends AppCompatActivity {

    ActivityNewSizeBinding binding;
    CustomDialogBinding bindingDialog;
    MyViewModel myViewModel;
    Dialog dialog;
    int serialNumber = 1;
    int electricConverterID;
    double number_R,number_S,number_T,number_N,number_RS,number_RT,
            number_ST,number_RN,number_SN,number_TN;

    ArrayList<Reading>readingArrayList;
    ReadingAdapter adapter;


    public  static  final  String READING_LIST_KEY="READING_LIST_KEY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityNewSizeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


         electricConverterID=getIntent().getExtras().getInt(DetailsActivity.ElectricConverterID_KEY);

        myViewModel= new ViewModelProvider(this).get(MyViewModel.class);

         readingArrayList=new ArrayList<>();
        setUpRecyclerView(readingArrayList);





        setUpDialog();

        binding.textView3.setOnClickListener(view -> dialog.show());




        binding.btnApproval.setOnClickListener(view -> {

            if(readingArrayList.isEmpty()){

                showMessageInfo();
            }

            //ToDo must un comment below
//              else if(!readingArrayList.isEmpty()&&readingArrayList.size()>0){
//
//                myViewModel.addMeasurement(readingArrayList, new MeasurementListener() {
//                    @Override
//                    public void getStatusCode(int statusCode) {
//                        if (statusCode == 200){
            // first solution
          //  ArrayList<Reading>readingArrayList= (ArrayList<Reading>) adapter.getItems();

//                    Intent intent = new Intent();
//                    intent.putExtra(READING_LIST_KEY, readingArrayList);
//                    setResult(RESULT_OK, intent);
//                    showMessageSuccess("تم اعتماد القياس");
//                    finish();

            //the two solution

//                showMessageSuccess("تم اعتماد القياس");
//                finish();
//                        }
//                        else showMessageError("لم يتم اعتماد القياس");
//                    }
//                });

        //}

            /////TODo Delete below
            else {

                showMessageSuccess();
                finish();

            }




        });






    }

    private void showMessageInfo() {

        Toasty.info(getBaseContext(), "يرجى اضافة قراءات لكي ينم اعتمادها", Toast.LENGTH_SHORT, true).show();

    }
    private void showMessageSuccess() {

        Toasty.success(getApplicationContext(), "تم اعتماد القياس", Toast.LENGTH_SHORT, true).show();

    }
    private void setUpDialog() {

        dialog=new Dialog(NewSizeActivity.this);
        bindingDialog= CustomDialogBinding.inflate(getLayoutInflater());
        dialog.setContentView(bindingDialog.getRoot());

        bindingDialog.close.setOnClickListener(view -> dialog.dismiss());


        bindingDialog.btnSend.setOnClickListener(view -> InputVerification());

        bindingDialog.btnRest.setOnClickListener(view -> restInput());
    }

    private void restInput() {

        bindingDialog.spinner.setSelection(0);
        restEditText(bindingDialog.editResidentialCapacity
        ,bindingDialog.editR
        ,bindingDialog.editS,bindingDialog.editT
        ,bindingDialog.editN,bindingDialog.editRS
        ,bindingDialog.editRT,bindingDialog.editST
        ,bindingDialog.editRN,bindingDialog.editSN,bindingDialog.editST,bindingDialog.editTN);
    }

    private void restEditText(EditText...editTexts){

        for (EditText editText : editTexts) {

            editText.setText("");
        }
    }


    public void setUpRecyclerView(List<Reading> list) {

         adapter = new ReadingAdapter(list, this);
        binding.rec.setAdapter(adapter);
        binding.rec.setLayoutManager(new LinearLayoutManager(this));
        binding.rec.setHasFixedSize(true);

    }


    private void InputVerification() {



        if(bindingDialog.spinner.getSelectedItemPosition()==0) showMessageError("الرجاء تحديد الاتجاه");
        else if (TextUtils.isEmpty(bindingDialog.editResidentialCapacity.getText().toString())){
            showMessageError("الرجاء ادخال  القدرة السكنية ");
        }
        else if (TextUtils.isEmpty(bindingDialog.editR.getText().toString())){
            showMessageError("الرجاء ادخال قيمة R ");
        }
        else if (TextUtils.isEmpty(bindingDialog.editS.getText().toString())){
            showMessageError("الرجاء ادخال قيمة S ");
        }
        else if (TextUtils.isEmpty(bindingDialog.editT.getText().toString())){
            showMessageError("الرجاء ادخال قيمة T ");
        }
        else if (TextUtils.isEmpty(bindingDialog.editN.getText().toString())){
            showMessageError("الرجاء ادخال قيمة N ");
        }
        else if (TextUtils.isEmpty(bindingDialog.editRS.getText().toString())){
            showMessageError("الرجاء ادخال قيمة RS ");
        }

        else if (TextUtils.isEmpty(bindingDialog.editRT.getText().toString())){
            showMessageError("الرجاء ادخال قيمة RT ");
        }
        else if (TextUtils.isEmpty(bindingDialog.editST.getText().toString())){
            showMessageError("الرجاء ادخال قيمة ST ");
        }

        else if (TextUtils.isEmpty(bindingDialog.editRN.getText().toString())){
            showMessageError("الرجاء ادخال قيمة RN ");
        }
        else if (TextUtils.isEmpty(bindingDialog.editSN.getText().toString())){
            showMessageError("الرجاء ادخال قيمة SN ");
        }
        else if (TextUtils.isEmpty(bindingDialog.editTN.getText().toString())){
            showMessageError("الرجاء ادخال قيمة TN ");
        }

        else {


            try {

                int   sp_Position= bindingDialog.spinner.getSelectedItemPosition();


               int  residential_capacity=Integer.parseInt(bindingDialog.editResidentialCapacity.getText().toString());
                 number_R=Double.parseDouble(bindingDialog.editR.getText().toString());
                 number_S=Double.parseDouble(bindingDialog.editS.getText().toString());
                 number_T=Double.parseDouble(bindingDialog.editT.getText().toString());
                 number_N=Double.parseDouble(bindingDialog.editN.getText().toString());
                 number_RS=Double.parseDouble(bindingDialog.editRS.getText().toString());
                 number_RT=Double.parseDouble(bindingDialog.editRT.getText().toString());
                 number_ST=Double.parseDouble(bindingDialog.editST.getText().toString());
                 number_RN=Double.parseDouble(bindingDialog.editRN.getText().toString());
                 number_SN=Double.parseDouble(bindingDialog.editSN.getText().toString());
                 number_TN=Double.parseDouble(bindingDialog.editTN.getText().toString());
                ///ToDo get user Id
                int userid=59;
                Calendar calendar = Calendar.getInstance();
                Date date = calendar.getTime();
                SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");
                String currentDate=simpleDateFormat.format(date);


                Reading reading=new Reading(serialNumber,electricConverterID,
                        sp_Position,residential_capacity,
                        number_R,number_S,number_T,number_N,number_RS
                        ,number_RT,number_ST,number_RN,number_SN,number_TN,userid,date.getTime());
                adapter.addItem(reading);
                binding.textBlank.setVisibility(View.GONE);
                dialog.dismiss();
                restInput();
                serialNumber++;
                adapter.notifyDataSetChanged();

            }catch (Exception e){

                showMessageError("الرجاء ادخال أرقام في جميع الحقول");
            }





        }



    }
    private void showMessageError(String massage) {

        Toasty.error(getBaseContext(), massage, Toast.LENGTH_SHORT, true).show();

    }

}