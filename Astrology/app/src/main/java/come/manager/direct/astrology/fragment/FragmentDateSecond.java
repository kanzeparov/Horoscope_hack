package come.manager.direct.astrology.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aigestudio.wheelpicker.WheelPicker;

import come.manager.direct.astrology.MainActivity;
import come.manager.direct.astrology.R;

public class FragmentDateSecond extends Fragment   implements WheelPicker.OnItemSelectedListener{
    private WheelPicker daywheel;
    private WheelPicker monthwheel;
    private WheelPicker yearwheel;

    private MainActivity mainActivity;
    // Store instance variables
    //  private String title;
    //  private int page;

    // newInstance constructor for creating fragment with arguments
    public static FragmentDateSecond newInstance() {
        FragmentDateSecond fragmentFirst = new FragmentDateSecond();
        //  Bundle args = new Bundle();
        //  args.putInt("someInt", page);
        //  args.putString("someTitle", title);
        //   fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  page = getArguments().getInt("someInt", 0);
        //  title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.date_layout_second, container, false);
        //  TextView tvLabel = (TextView) view.findViewById(R.id.tvLabel);
        //   tvLabel.setText(page + " -- " + title);
        daywheel = view.findViewById(R.id.wheel_day);
        daywheel.setOnItemSelectedListener(this);
        monthwheel = view.findViewById(R.id.wheel_month);
        monthwheel.setOnItemSelectedListener(this);
        yearwheel = view.findViewById(R.id.wheel_year);
        yearwheel.setOnItemSelectedListener(this);

        mainActivity = (MainActivity)getActivity();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mainActivity.setDaySecond(daywheel.getData().get(daywheel.getCurrentItemPosition()).toString());
        mainActivity.setMonthSecond(monthwheel.getData().get(daywheel.getCurrentItemPosition()).toString());
        mainActivity.setYearSecond(yearwheel.getData().get(daywheel.getCurrentItemPosition()).toString());
    }

    @Override
    public void onItemSelected(WheelPicker picker, Object data, int position) {
        String text = "";
        switch (picker.getId()) {
            case R.id.wheel_day:
                text = "day:";
                mainActivity.setDaySecond(String.valueOf(data));
                break;
            case R.id.wheel_month:
                text = "month:";
                mainActivity.setMonthSecond(String.valueOf(data));
                break;
            case R.id.wheel_year:
                text = "year:";
                mainActivity.setYearSecond(String.valueOf(data));
                break;
        }
        Toast.makeText(getActivity(), text + String.valueOf(data), Toast.LENGTH_SHORT).show();
    }
}