package come.manager.direct.astrology.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aigestudio.wheelpicker.WheelPicker;

import come.manager.direct.astrology.MainActivity;
import come.manager.direct.astrology.R;

public class FragmentCardView6  extends Fragment {

    private static String INFO;



    // Store instance variables
    //  private String title;
    //  private int page;

    // newInstance constructor for creating fragment with arguments
    public static FragmentCardView6 newInstance(String info) {
        FragmentCardView6 fragmentFirst = new FragmentCardView6();
        INFO = info;
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
        View view = inflater.inflate(R.layout.fragment_card_view6, container, false);
        String[] s = INFO.split("---");
        TextView tvLabel = (TextView) view.findViewById(R.id.aspekt_text6);
        TextView tvinfo = (TextView) view.findViewById(R.id.info_aspect6);
        tvLabel.setText(s[0]);
        tvinfo.setText(s[1].substring(0,1).toUpperCase()+s[1].substring(1));
        //   tvLabel.setText(page + " -- " + title);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

}