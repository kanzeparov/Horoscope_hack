package come.manager.direct.astrology;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.RequestBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import come.manager.direct.astrology.internet.APITask;
import come.manager.direct.astrology.internet.IAPITaskCallBack;
import come.manager.direct.astrology.pojo.Aspect;
import come.manager.direct.astrology.pojo.CalculatePeople;
import come.manager.direct.astrology.pojo.Example;
import come.manager.direct.astrology.pojo.InitDescription;
import come.manager.direct.astrology.pojo.Result;

public class LoadingActivity extends AppCompatActivity implements IAPITaskCallBack{
    private CalculatePeople calculatePeople;
    private ArrayList<Result> resultList;
    private Handler handler;
    private static final int SUCCESS = 99;

    private String USER_ID = "604002"; // eg "4545"
    private String API_KEY = "484005ee37dc7a07357cf530abd9eb77";
    // eg "https://astrologyapi.com/"
    private String API_END_POINT = "https://api.vedicrishiastro.com/v1/";
    private int astroInteger;// DON'T CHANGE THIS LINE

    class IncomingHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case SUCCESS:
                    try {

                        String res = (String) msg.obj;
                        Gson gson = new GsonBuilder().create();
                        Example r = gson.fromJson(res, Example.class);
                        List<Aspect> aspects = r.getSynastry().getAspects();
                        for(int i = 0; i < 30; i++) {
                            aspects.add(aspects.get(i));
                        }

                        boolean[] resultBool = new boolean[resultList.size()];
                        for (int i = 0; i < resultList.size(); i++) {
                            resultBool[i] = resultList.get(i).appropStatus(aspects.get(i).getOrb().intValue());
                        }

                        Intent intent = new Intent(LoadingActivity.this, ResultActivity.class);
                        intent.putExtra("result", resultBool);
                        intent.putExtra("hash", astroInteger);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                        boolean[] resultBool = new boolean[resultList.size()];
                        for (int i = 0; i < resultList.size(); i++) {
                            resultBool[i] = resultList.get(i).appropStatus(31);
                        }

                        Intent intent = new Intent(LoadingActivity.this, ResultActivity.class);
                        intent.putExtra("result", resultBool);
                        intent.putExtra("hash", astroInteger);
                        startActivity(intent);
                        finish();
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        calculatePeople = getIntent().getParcelableExtra("people");
        astroInteger = calculatePeople.getDayFirst().hashCode() + calculatePeople.getMonthFirst().hashCode() +
                calculatePeople.getYearFirst().hashCode() + calculatePeople.getHourFirst().hashCode() +
                calculatePeople.getMinuteFirst().hashCode() + calculatePeople.getCityFirst().hashCode();
        //InitDescription.initResult();
//        countNeg = 0;
//        countNet = 0;
//        countPos = 0;
        resultList = InitDescription.resultArrayList;
        new AsyncTasker().execute();

        handler = new IncomingHandler();
        

    }
    @Override
    public void onSuccess(String response) {
        Log.i("Test Activity", "Response : " + response);
        Message message = Message.obtain();
        message.what = SUCCESS;
        message.obj = response;
        handler.sendMessage(message);
    }

    @Override
    public void onFailure(String error) {
        Log.e("Test Activity Error", "Response : " + error);
        boolean[] resultBool = new boolean[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultBool[i] = resultList.get(i).appropStatus(31);
        }

        Intent intent = new Intent(LoadingActivity.this, ResultActivity.class);
        intent.putExtra("result", resultBool);
        intent.putExtra("hash", astroInteger);
        startActivity(intent);
        finish();
    }

    private void executeAPI(String apiName, RequestBody formData)
    {
        String url = API_END_POINT+apiName;
        APITask apiTask = new APITask(url, USER_ID, API_KEY, formData, LoadingActivity.this);
        Thread thread = new Thread(apiTask);
        thread.start();
    }
    private class AsyncTasker extends AsyncTask<Void, Void, Void> {
        private String[] cities = getResources().getStringArray(R.array.cities);
        private String[] city_hours = getResources().getStringArray(R.array.citihour);
        private String[] months = getResources().getStringArray(R.array.months);
        private long diff;

        @Override
        protected Void doInBackground(Void... voids) {
            String firstCityHour = "00";
            String secondCityHour = "00";
            Date answer =  new Date();
            Date firstBirthDay=  new Date();
            Date secondBirthDay=  new Date();

            if (calculatePeople != null) {
                for (int i = 0; i < cities.length; i++) {
                    if (cities[i].equals(calculatePeople.getCityFirst())) {
                        firstCityHour = city_hours[i];
                    }
                    if (cities[i].equals(calculatePeople.getCitySecond())) {
                        secondCityHour = city_hours[i];
                    }
                }
            }

            try {
                DateFormat df = new SimpleDateFormat("hh:mm:ss_yyyy.MM.dd");
                long firstDifCity = new Integer(firstCityHour) * 3_600_000;
                long secondDifCity = new Integer(secondCityHour) * 3_600_000;
                String firstMonth = "";
                String secondMonth = "";
                for(int i = 0; i < months.length; i++) {
                    if(months[i].equals(calculatePeople.getMonthFirst())) {
                        if(i < 9) {
                            firstMonth += "0"+(i+1);
                        } else {
                            firstMonth += (i+1);
                        }
                    }
                    if(months[i].equals(calculatePeople.getMonthSecond())) {
                        if(i < 9) {
                            secondMonth += "0"+(i+1);
                        } else {
                            secondMonth += (i+1);
                        }
                    }
                }
                firstBirthDay = df.parse(calculatePeople.getHourFirst() + ":" +
                        calculatePeople.getMinuteFirst() + ":00_" +
                        calculatePeople.getYearFirst() + "." +
                        firstMonth + "." +
                        calculatePeople.getDayFirst());
                secondBirthDay = df.parse(calculatePeople.getHourSecond() + ":" +
                        calculatePeople.getMinuteSecond() + ":00_" +
                        calculatePeople.getYearSecond() + "." +
                        secondMonth + "." +
                        calculatePeople.getDaySecond());

                long diff = ((firstBirthDay.getTime() - firstDifCity)+(secondBirthDay.getTime()-secondDifCity))/2;
                this.diff = diff;

                answer = new Date(diff);
            } catch (ParseException e) {
                Log.e("TEST", "Exception", e);
            }

            resultList = InitDescription.resultArrayList;
            String s = firstBirthDay.getDay()+1+"";
            s=(firstBirthDay.getMonth()+1)+"";
            s=(firstBirthDay.getYear()+1900)+"";
            s=firstBirthDay.getHours()+"";
            s=firstBirthDay.getMinutes()+"";
            s = (secondBirthDay.getDay()+1)+"";
            s=(secondBirthDay.getMonth()+1)+"";
            s=(secondBirthDay.getYear()+1900)+"";
            s=secondBirthDay.getHours()+"";
            s=secondBirthDay.getMinutes()+"";
            RequestBody formBody = new FormEncodingBuilder()
                    .add("p_day", (firstBirthDay.getDay()+1)+"")
                    .add("p_month", (firstBirthDay.getMonth()+1)+"")
                    .add("p_year", (firstBirthDay.getYear()+1900)+"")
                    .add("p_hour", firstBirthDay.getHours()+"")
                    .add("p_min", firstBirthDay.getMinutes()+"")
                    .add("p_lat", "55.7512")
                    .add("p_lon", "37.6184")
                    .add("p_tzone", "0.0")
                    .add("s_day", (secondBirthDay.getDay()+1)+"")
                    .add("s_month", (secondBirthDay.getMonth()+1)+"")
                    .add("s_year", (secondBirthDay.getYear()+1900)+"")
                    .add("s_hour", secondBirthDay.getHours()+"")
                    .add("s_min", secondBirthDay.getMinutes()+"")
                    .add("s_lat", "55.7512")
                    .add("s_lon", "37.6184")
                    .add("s_tzone", "0.0")
                    .build();

//            RequestBody formBody = new FormEncodingBuilder()
//                    .add("day", "15")
//                    .add("month", "8")
//                    .add("year", "1987")
//                    .add("hour", "00")
//                    .add("min", "49")
//                    .add("lat", "28.4700")
//                    .add("lon", "77.0300")
//                    .add("tzone", "5.5")
//                    .build();
            // the first argument is the API name
            // for ex- planets or astro_details or general_house_report/sun
            // you can get the API names from https://www.vedicrishiastro.com/docs
            // NOTE: please make sure there is no / before the API name.
            // for example /astro_details will give an error
            if(hasConnection(getApplicationContext())) {
                executeAPI("synastry_horoscope", formBody);
            } else {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //Toast.makeText(getApplicationContext(),"Включите интернет",Toast.LENGTH_LONG).show();
                        onFailure("error");
                    }
                });

            }
//            try {
//                Thread.sleep(3_000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {


        }
    }

    public static boolean hasConnection(final Context context)
    {
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiInfo != null && wifiInfo.isConnected())
        {
            return true;
        }
        wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifiInfo != null && wifiInfo.isConnected())
        {
            return true;
        }
        wifiInfo = cm.getActiveNetworkInfo();
        if (wifiInfo != null && wifiInfo.isConnected())
        {
            return true;
        }
        return false;
    }
}
