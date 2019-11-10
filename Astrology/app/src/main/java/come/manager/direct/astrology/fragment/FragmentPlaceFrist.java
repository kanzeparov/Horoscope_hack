package come.manager.direct.astrology.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import come.manager.direct.astrology.MainActivity;
import come.manager.direct.astrology.R;

public class FragmentPlaceFrist extends Fragment {

    // Store instance variables
    //  private String title;
    //  private int page;
    private MainActivity mainActivity;
    private AutoCompleteTextView autoCompleteTextView;

    // newInstance constructor for creating fragment with arguments
    public static FragmentPlaceFrist newInstance() {
        FragmentPlaceFrist fragmentFirst = new FragmentPlaceFrist();
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

    @Override
    public void onResume() {
        super.onResume();
        mainActivity.setCityFirst(autoCompleteTextView.getText().toString());
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.place_layout_first, container, false);
        autoCompleteTextView = view.findViewById(R.id.autotext);
        String[] cities = getActivity().getResources().getStringArray(R.array.cities);
        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, cities));
        autoCompleteTextView.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                //Toast.makeText(getActivity(), autoCompleteTextView.getText().toString(), Toast.LENGTH_LONG).show();
                mainActivity.setCityFirst(autoCompleteTextView.getText().toString());
            }

            public void beforeTextChanged(CharSequence s, int start,
                    int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                    int before, int count) {

            }
        });
        mainActivity = (MainActivity) getActivity();
        //  TextView tvLabel = (TextView) view.findViewById(R.id.tvLabel);
        //   tvLabel.setText(page + " -- " + title);
        return view;
    }
}