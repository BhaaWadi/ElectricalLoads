package com.example.electricalloads.Pojo;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public  class APIClient {

   private static Retrofit retrofit = null;

   // الميثود ديه static ليه  static
   //علشان انا استدعيها ياسم الكلاس مرة واحدة لانو الاعدادات يتلزمني  مرة واحدة
  public static Retrofit getClient() {

       // السطرين دول علشان نعمل Logging يعني نعمل تتبع للريكوست في اللوكات
       HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
       //تم تحديد اللفل التفاصيل  الخاصة بالريكوست
       //       ايش معناة الكلام ده معناتو انو انتا لما تبعت ريكوست على السيرفر ويجيك ريسيونس  بدك التفاصيل الي تطلع في اللوكات تفاصيل Body يعني ابعت كل حاجة يا كبير
       interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

       // لو انتا يا كبير اتشاطرت وما حطيت السطرين الى فوق مش هيعطيك الخطأ في اللوكات

       OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


       retrofit = new Retrofit.Builder()
               //TODo enter the base url
               .baseUrl("https://jsonplaceholder.typicode.com")
               //السطر اللذيد ده علشان يعمل تحويل دينامكي من جيسون لاوبجكت جافا
               .addConverterFactory(GsonConverterFactory.create())
               .client(client)
               .build();



       return retrofit;
   }

}
