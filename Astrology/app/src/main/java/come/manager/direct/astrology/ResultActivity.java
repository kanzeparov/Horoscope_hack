package come.manager.direct.astrology;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.RequestBody;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import come.manager.direct.astrology.fragment.FragmentCardView;
import come.manager.direct.astrology.fragment.FragmentCardView1;
import come.manager.direct.astrology.fragment.FragmentCardView2;
import come.manager.direct.astrology.fragment.FragmentCardView3;
import come.manager.direct.astrology.fragment.FragmentCardView4;
import come.manager.direct.astrology.fragment.FragmentCardView5;
import come.manager.direct.astrology.fragment.FragmentCardView6;
import come.manager.direct.astrology.fragment.FragmentDateFirst;
import come.manager.direct.astrology.fragment.FragmentDateSecond;
import come.manager.direct.astrology.fragment.FragmentPlaceFrist;
import come.manager.direct.astrology.fragment.FragmentPlaceSecond;
import come.manager.direct.astrology.fragment.FragmentTimeFirst;
import come.manager.direct.astrology.fragment.FragmentTimeSecond;
import come.manager.direct.astrology.pojo.InitDescription;
import come.manager.direct.astrology.pojo.Result;

public class ResultActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";

    private float[] yData = {0f, 3f, 2f};
    private static String[] xData = {"Positive", "Netral", "Negative"};
    private boolean[] result;
    private PieChart pieChart;
    private Button sadBtn;
    private ArrayList<Result> resultList;
    private Button smileBtn;
    private Button netButton;
    private Button button;
    private float countNeg;
    private String[] infoPos;
    private String[] infoNeg;
    private String[] infoNet;
    private float countNet;
    private float countPos;
    private TabLayout tabLayout;
    private int astro;
    private ViewPager vpPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Log.d(TAG, "onCreate: starting to create chart");

        Toast.makeText(getApplicationContext(), new Date(getIntent().getLongExtra("date", 0)).toString(), Toast.LENGTH_LONG).show();

        result = getIntent().getBooleanArrayExtra("result");
        astro = getIntent().getIntExtra("hash",0);
        countNeg = 0;
        countNet = 0;
        countPos = 0;
        InitDescription.initResult();
        resultList = InitDescription.resultArrayList;

        for (int i = 0; i < result.length; i++) {
            if (result[i] && resultList.get(i).getType().equals("NEG")) {
                countNeg++;
            }
            if (result[i] && resultList.get(i).getType().equals("NET")) {
                countNet++;
            }
            if (result[i] && resultList.get(i).getType().equals("POS")) {
                countPos++;
            }
        }

        infoPos = new String[(int) countPos];
        infoNeg = new String[(int) countNeg];
        infoNet = new String[(int) countNet];
        int net = 0;
        int pos = 0;
        int neg = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] && resultList.get(i).getType().equals("NET")) {
                infoNet[net] = resultList.get(i).getNameFirst() + "---" + resultList.get(i).getDescription();
                net++;
            }
            if (result[i] && resultList.get(i).getType().equals("POS")) {
                infoPos[pos] = resultList.get(i).getNameFirst() + "---" + resultList.get(i).getDescription();
                pos++;
            }
            if (result[i] && resultList.get(i).getType().equals("NEG")) {
                infoNeg[neg] = resultList.get(i).getNameFirst() + "---" + resultList.get(i).getDescription();
                neg++;
            }
        }

        yData = new float[] {countPos, countNet, countNeg};

        sadBtn = findViewById(R.id.sadBtn);
        smileBtn = findViewById(R.id.smileBtn);
        netButton = findViewById(R.id.netBtn);
        sadBtn.setText(countNeg + "");
        smileBtn.setText(countPos + "");
        netButton.setText(countNet + "");
        pieChart = findViewById(R.id.idPieChart);
        vpPager = findViewById(R.id.vpPager);
        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(40f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("");
        pieChart.setCenterTextSize(10);
        pieChart.setDrawSliceText(false);

        addDataSet();

        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Log.d(TAG, "onValueSelected: Value select from chart.");
                Log.d(TAG, "onValueSelected: " + e.toString());
                Log.d(TAG, "onValueSelected: " + h.toString());

                int pos1 = e.toString().indexOf("(sum): ");
                String sales = e.toString().substring(pos1 + 17);

                for (int i = 0; i < yData.length; i++) {
                    if (yData[i] == Float.parseFloat(sales)) {
                        pos1 = i;
                        break;
                    }
                }
                String employee = xData[pos1];
                Toast.makeText(ResultActivity.this, "Employee " + employee + "\n" + "Sales: $" + sales + "K", Toast.LENGTH_LONG).show();

                if (employee.equals(xData[0])) {
                    smileBtn.callOnClick();
                } else if (employee.equals(xData[1])) {
                    netButton.callOnClick();
                } else if (employee.equals(xData[2])) {
                    sadBtn.callOnClick();
                }
            }

            @Override
            public void onNothingSelected() {

            }
        });

        button = findViewById(R.id.buttonNext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vpPager.setCurrentItem(vpPager.getCurrentItem() + 1);

                if (button.getText().toString().equals(getResources().getString(R.string.calculate))) {
                    startActivity(new Intent(getApplicationContext(), HelloActivity.class));
                }
            }
        });

        smileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeClickable(true, false, false);
                changeDefault(false, true, true);
                vpPager.clearOnPageChangeListeners();
                vpPager.setAdapter(null);

                final MyPagerAdapter adapterViewPager = new MyPagerAdapter(getSupportFragmentManager(), infoPos);
                vpPager.setAdapter(adapterViewPager);
                vpPager.getAdapter().notifyDataSetChanged();
                tabLayout = (TabLayout) findViewById(R.id.tabDots);
                tabLayout.setupWithViewPager(vpPager, true);
                vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    public void onPageScrollStateChanged(int state) {
                    }

                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        if (position == adapterViewPager.getCount() - 1) {
                            button.setText(R.string.calculate);
                        } else {
                            button.setText(R.string.next);
                        }
                    }

                    public void onPageSelected(int position) {

                    }
                });
            }
        });

        sadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeClickable(false, false, true);
                changeDefault(true, true, false);

                vpPager.clearOnPageChangeListeners();
                vpPager.setAdapter(null);

                final MyPagerAdapter adapterViewPager = new MyPagerAdapter(getSupportFragmentManager(), infoNeg);
                adapterViewPager.notifyDataSetChanged();
                vpPager.setAdapter(adapterViewPager);
                vpPager.getAdapter().notifyDataSetChanged();
                tabLayout = (TabLayout) findViewById(R.id.tabDots);
                tabLayout.setupWithViewPager(vpPager, true);
                vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    public void onPageScrollStateChanged(int state) {
                    }

                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        if (position == adapterViewPager.getCount() - 1) {
                            button.setText(R.string.calculate);
                        } else {
                            button.setText(R.string.next);
                        }
                    }

                    public void onPageSelected(int position) {

                    }
                });
            }
        });

        netButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeClickable(false, true, false);
                changeDefault(true, false, true);

                vpPager.clearOnPageChangeListeners();
                vpPager.setAdapter(null);
                final MyPagerAdapter adapterViewPager = new MyPagerAdapter(getSupportFragmentManager(), infoNet);
                adapterViewPager.notifyDataSetChanged();
                vpPager.setAdapter(adapterViewPager);
                vpPager.getAdapter().notifyDataSetChanged();
                tabLayout = (TabLayout) findViewById(R.id.tabDots);
                tabLayout.setupWithViewPager(vpPager, true);
                vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    public void onPageScrollStateChanged(int state) {
                        Toast.makeText(getApplicationContext(), state + "", Toast.LENGTH_LONG).show();

                    }

                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        if (position == adapterViewPager.getCount() - 1) {
                            button.setText(R.string.calculate);
                        } else {
                            button.setText(R.string.next);
                        }
                    }

                    public void onPageSelected(int position) {

                    }
                });
            }
        });

    }

    private void changeDefault(boolean smileBtn, boolean netBtn, boolean sadBtn) {
        if (smileBtn) {
            this.smileBtn.setBackgroundResource(R.drawable.emoji_default);
            this.smileBtn.setTextColor(getColorWrapper(getApplicationContext(), R.color.pos_chart));
        }

        if (netBtn) {
            this.netButton.setBackgroundResource(R.drawable.emoji_default);
            this.netButton.setTextColor(getColorWrapper(getApplicationContext(), R.color.neu_chart));
        }

        if (sadBtn) {
            this.sadBtn.setBackgroundResource(R.drawable.emoji_default);
            this.sadBtn.setTextColor(getColorWrapper(getApplicationContext(), R.color.neg_chart));
        }
    }

    private void changeClickable(boolean smileBtn, boolean netBtn, boolean sadBtn) {
        if (smileBtn) {
            this.smileBtn.setBackgroundResource(R.drawable.smile_round_btn_pos);
            this.smileBtn.setTextColor(getColorWrapper(getApplicationContext(), R.color.white));
        }

        if (netBtn) {
            this.netButton.setBackgroundResource(R.drawable.smile_round_btn_net);
            this.netButton.setTextColor(getColorWrapper(getApplicationContext(), R.color.white));
        }

        if (sadBtn) {
            this.sadBtn.setBackgroundResource(R.drawable.smile_round_btn_neg);
            this.sadBtn.setTextColor(getColorWrapper(getApplicationContext(), R.color.white));
        }
    }

    private void addDataSet() {
        Log.d(TAG, "addDataSet started");
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        for (int i = 0; i < yData.length; i++) {
            yEntrys.add(new PieEntry(yData[i], i));
        }

        for (int i = 1; i < xData.length; i++) {
            xEntrys.add(xData[i]);
        }

        //create the data set
        PieDataSet pieDataSet = new PieDataSet(yEntrys, "");
        pieDataSet.setUsingSliceColorAsValueLineColor(false);
        pieDataSet.setSliceSpace(2);
        pieDataSet.setDrawIcons(false);
        pieDataSet.setValueTextSize(12);
        Legend leg = pieChart.getLegend();
        leg.setEnabled(false);
        Description des = pieChart.getDescription();
        des.setEnabled(false);
        //add colors to dataset
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(getColorWrapper(getApplicationContext(), R.color.pos_chart));
        colors.add(getColorWrapper(getApplicationContext(), R.color.neu_chart));
        colors.add(getColorWrapper(getApplicationContext(), R.color.neg_chart));

        pieDataSet.setColors(colors);

        //add legend to chart

        //create pie data object
        PieData pieData = new PieData(pieDataSet);

        pieData.setDrawValues(false);
        pieChart.setData(pieData);

        pieChart.invalidate();
    }

    public static class MyPagerAdapter extends FragmentStatePagerAdapter {
        public int NUM_ITEMS = 6;
        private String[] info;


        private int pagerAdapterPosChanged = POSITION_UNCHANGED;
        private static final int TOGGLE_ENABLE_POS = 2;




//        @Override
//        public Fragment getItem(int i) {
//
//                    return FragmentCardView.newInstance(info[i]);
//
//        }

        @Override
        public int getCount() {
            return info.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Tab " + (position + 1);
        }

        @Override
        public int getItemPosition(Object object) {

            //  This check make sures getItem() is called only for the required Fragment
            if (object instanceof FragmentCardView)
                return pagerAdapterPosChanged;

            return POSITION_UNCHANGED;
        }

        /**
         * Switch fragments Interface implementation
         */


        /**
         * Interface to switch frags
         */


        public MyPagerAdapter(FragmentManager fragmentManager, String[] info) {
            super(fragmentManager);
            NUM_ITEMS = info.length;
            this.info = info;
        }



        // Returns total number of pages
//        @Override
//        public int getCount() {
//            return NUM_ITEMS;
//        }

        // Returns the fragment to display for that page
//        @Override
        public Fragment getItem(int position) {
           //// return FragmentCardView.newInstance(info[position]);
            int realpos = position % 7;
                switch (realpos) {
                    case 0:
                        return FragmentCardView.newInstance(info[position]);
                    case 1:
                        return FragmentCardView1.newInstance(info[position]);
                    case 2:
                        return FragmentCardView2.newInstance(info[position]);
                    case 3:
                        return FragmentCardView3.newInstance(info[position]);
                    case 4:
                        return FragmentCardView4.newInstance(info[position]);
                    case 5:
                        return FragmentCardView5.newInstance(info[position]);
                    case 6:
                        return FragmentCardView6.newInstance(info[position]);
                    default:
                        return null;
                }
        }

        // Returns the page title for the top indicator
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return "Page " + position;
//        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        smileBtn.callOnClick();
    }

    public static int getColorWrapper(Context context, int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return context.getColor(id);
        } else {
            //noinspection deprecation
            return context.getResources().getColor(id);
        }
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
