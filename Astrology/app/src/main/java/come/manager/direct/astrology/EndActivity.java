package come.manager.direct.astrology;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import come.manager.direct.astrology.pojo.CalculatePeople;
import come.manager.direct.astrology.pojo.Post;
import come.manager.direct.astrology.retrofit.NetworkService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EndActivity extends AppCompatActivity {
    private CalculatePeople calculatePeople;
    private TextView textView;
    private String API_END_POINT = "http://34.87.49.51/hero/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        Button button = findViewById(R.id.btn_again);
        textView = findViewById(R.id.info_txt_1);
        calculatePeople = getIntent().getParcelableExtra("people");
        int astroInteger = calculatePeople.getDayFirst().hashCode() + calculatePeople.getMonthFirst().hashCode() +
                calculatePeople.getYearFirst().hashCode() + calculatePeople.getHourFirst().hashCode() +
                calculatePeople.getMinuteFirst().hashCode() + calculatePeople.getCityFirst().hashCode();
        Toast.makeText(getApplicationContext(), "Main " + astroInteger % 11, Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), calculatePeople.getDayFirst(), Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), calculatePeople.getMonthFirst(), Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), calculatePeople.getYearFirst(), Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), calculatePeople.getHourFirst(), Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), calculatePeople.getMinuteFirst(), Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), calculatePeople.getCityFirst(), Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), calculatePeople.getCitySecond(), Toast.LENGTH_LONG).show();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoadingActivity.class);
                i.putExtra("people", calculatePeople);
                startActivity(i);
            }
        });

        ImageButton imageButton = findViewById(R.id.inst_btn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/kanzeparov")); startActivity(browserIntent);
            }
        });

        NetworkService.getInstance()
                .getJSONApi()
                .getPostWithID(calculatePeople.getHourSecond())
                .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                        Post post = response.body();

                        textView.setText("");
                    }

                    @Override
                    public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {

                        textView.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
    }

    private class AsyncTasker extends AsyncTask<Void, Void, Void> {

        private long diff;

        @Override
        protected Void doInBackground(Void... voids) {

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {


        }
    }
}
