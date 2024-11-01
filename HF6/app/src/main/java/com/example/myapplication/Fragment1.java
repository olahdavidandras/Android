package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    protected static final String FRAG2 = "2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        final String[] nameArray = {"EUR", "USD", "GBP", "AUD", "CAD", "CHF", "DKK", "HUF"};
        final String[] infoArray = {"Euro", "Dolar american", "Lira sterlina", "Dolar australian", "Dolar canadian", "Franc elvetian", "Coroana daneza", "Forint maghiar"};
        final String[] cumparaArray = {"4,4100 RON", "3,9750 RON", "6,1250 RON", "2,9600 RON", "3,0950 RON", "4,2300 RON", "0,5850 RON", "0,0136 RON"};
        final String[] vindeArray = {"4,5500 RON", "4,1450 RON", "6,3550 RON", "3,0600 RON", "3,2650 RON", "4,3300 RON", "0,6150 RON", "0,0146 RON"};
        final Integer[] imageArray = {
                R.drawable.eu,
                R.drawable.usa,
                R.drawable.gb,
                R.drawable.australia,
                R.drawable.canada,
                R.drawable.switzerland,
                R.drawable.denmark,
                R.drawable.hungary
        };

        ListView list = view.findViewById(R.id.valutaList);
        CustomListAdapter adapter = new CustomListAdapter(getActivity(), nameArray, infoArray, cumparaArray, vindeArray, imageArray);
        list.setAdapter(adapter);

        FragmentManager fm = getParentFragmentManager();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedInfo = "Currency: " + nameArray[position] + "\n" +
                        "Description: " + infoArray[position] + "\n" +
                        "Buy Price: " + cumparaArray[position] + "\n" +
                        "Sell Price: " + vindeArray[position];

                if (fm.findFragmentByTag(FRAG2) != null) {
                    // Display details in Fragment2 if it exists
                    TextView selectedOpt = getActivity().findViewById(R.id.selectedValuta);
                    selectedOpt.setText(selectedInfo);
                } else {
                    // Pass details to ShowItemActivity if Fragment2 is not present
                    Intent intent = new Intent(getActivity().getApplicationContext(), ShowItemActivity.class);
                    intent.putExtra("itemDetails", selectedInfo);
                    startActivity(intent);
                }
            }
        });

        return view;
    }


}