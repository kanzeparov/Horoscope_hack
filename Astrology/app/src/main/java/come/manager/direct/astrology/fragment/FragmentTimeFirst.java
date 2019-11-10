package come.manager.direct.astrology.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aigestudio.wheelpicker.WheelPicker;

import come.manager.direct.astrology.MainActivity;
import come.manager.direct.astrology.R;

public class FragmentTimeFirst extends Fragment  implements WheelPicker.OnItemSelectedListener{
    private WheelPicker hourwheel;
    private WheelPicker minutewheel;

    private MainActivity mainActivity;
    // Store instance variables
    //  private String title;
    //  private int page;

    // newInstance constructor for creating fragment with arguments
    public static FragmentTimeFirst newInstance() {
        FragmentTimeFirst fragmentFirst = new FragmentTimeFirst();
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
        View view = inflater.inflate(R.layout.time_layout_first, container, false);
        hourwheel = view.findViewById(R.id.wheel_hour);
        hourwheel.setOnItemSelectedListener(this);
        minutewheel = view.findViewById(R.id.wheel_minute);
        minutewheel.setOnItemSelectedListener(this);
        //  TextView tvLabel = (TextView) view.findViewById(R.id.tvLabel);
        //   tvLabel.setText(page + " -- " + title);
        mainActivity = (MainActivity)getActivity();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mainActivity.setHourFirst(hourwheel.getData().get(hourwheel.getCurrentItemPosition()).toString());
        mainActivity.setMinuteFirst(minutewheel.getData().get(minutewheel.getCurrentItemPosition()).toString());
    }

    @Override
    public void onItemSelected(WheelPicker picker, Object data, int position) {
        String text = "";
        switch (picker.getId()) {
            case R.id.wheel_hour:
                text = "hour:";
                mainActivity.setHourFirst(String.valueOf(data));
                break;
            case R.id.wheel_minute:
                text = "minute:";
                mainActivity.setMinuteFirst(String.valueOf(data));
                break;
        }
        //Toast.makeText(getActivity(), text + String.valueOf(data), Toast.LENGTH_SHORT).show();
    }
}