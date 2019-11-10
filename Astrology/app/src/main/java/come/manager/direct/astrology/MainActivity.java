package come.manager.direct.astrology;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import com.aigestudio.wheelpicker.WheelPicker;
import com.wx.wheelview.adapter.ArrayWheelAdapter;
import com.wx.wheelview.widget.WheelView;

import java.util.ArrayList;
import java.util.List;

import come.manager.direct.astrology.fragment.FragmentDateFirst;
import come.manager.direct.astrology.fragment.FragmentDateSecond;
import come.manager.direct.astrology.fragment.FragmentPlaceFrist;
import come.manager.direct.astrology.fragment.FragmentPlaceSecond;
import come.manager.direct.astrology.fragment.FragmentTimeFirst;
import come.manager.direct.astrology.fragment.FragmentTimeSecond;
import come.manager.direct.astrology.pojo.CalculatePeople;

public class MainActivity extends AppCompatActivity {

    private FragmentPagerAdapter adapterViewPager;
    private Button button;
    private AutoCompleteTextView autoCompleteTextView;
    private CalculatePeople calculatePeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculatePeople = new CalculatePeople();
        final ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
        button = findViewById(R.id.my_rounded_sign_in_button);
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(vpPager, true);

        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 3) {
                    button.setText(R.string.calculate);
//                    calculatePeople.setCityFirst("first");
//                    calculatePeople.setYearFirst("1111");
//                    calculatePeople.setMonthFirst("111");
//                    calculatePeople.setDayFirst("11");
//                    calculatePeople.setHourFirst("1");
//                    calculatePeople.setMinuteFirst("1");
//                    calculatePeople.setCitySecond("second");
//                    calculatePeople.setYearSecond("2222");
//                    calculatePeople.setMonthSecond("222");
//                    calculatePeople.setDaySecond("22");
//                    calculatePeople.setHourSecond("2");
//                    calculatePeople.setMinuteSecond("2");
                }
                else {
                    button.setText(R.string.next);
                }
            }

            public void onPageSelected(int position) {
                // Check if this is the page you want.
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vpPager.setCurrentItem(vpPager.getCurrentItem() + 1);

                if (button.getText().toString().equals(getResources().getString(R.string.calculate))) {
                    Intent i = new Intent(getApplicationContext(), EndActivity.class);
                    calculatePeople.setHourSecond("Сегодня");
                    i.putExtra("people", calculatePeople);
                    startActivity(i);
                }
            }
        });
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        public static int NUM_ITEMS = 4;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return FragmentDateFirst.newInstance();
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return FragmentTimeFirst.newInstance();
                case 2: // Fragment # 0 - This will show FirstFragment
                    return FragmentPlaceFrist.newInstance();
                case 3: // Fragment # 0 - This will show FirstFragment
                    return FragmentPlaceSecond.newInstance();
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }

    public void setDayFirst(String data) {
        calculatePeople.setDayFirst(data);
    }

    public void setDaySecond(String data) {
        calculatePeople.setDaySecond(data);
    }


    public void setMonthFirst(String data) {
        calculatePeople.setMonthFirst(data);
    }

    public void setMonthSecond(String data) {
        calculatePeople.setMonthSecond(data);
    }

    public void setYearFirst(String data) {
        calculatePeople.setYearFirst(data);
    }

    public void setYearSecond(String data) {
        calculatePeople.setYearSecond(data);
    }


    public void setHourFirst(String data) {
        calculatePeople.setHourFirst(data);
    }

    public void setHourSecond(String data) {
        calculatePeople.setHourSecond(data);
    }

    public void setMinuteFirst(String data) {
        calculatePeople.setMinuteFirst(data);
    }

    public void setMinuteSecond(String data) {
        calculatePeople.setMinuteSecond(data);
    }

    public void setCityFirst(String data) {
        calculatePeople.setCityFirst(data);
    }

    public void setCitySecond(String data) {
        calculatePeople.setCitySecond(data);
    }

}
