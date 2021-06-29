package com.example.recyclerviewwithfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetialFragment#newInstance} factory method to
 * create an instance of this DetialFragment.
 */
public class DetialFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the DetialFragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
    RecyclerView recyclerView;
    CustomAdapter adapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
//    private String mParam2;

    public DetialFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this DetialFragment using the provided parameters.
     *
     * @param param1 Parameter 1.

     * @return A new instance of DetialFragment DetialFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetialFragment newInstance(String param1) {
        DetialFragment fragment = new DetialFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
           // mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this DetialFragment
        View view= inflater.inflate(R.layout.detail_layout_fragment, container, false);


         TextView v= view.findViewById(R.id.text_view_detail);
         Log.v("DetailFragment",v.toString());
           v.setText(mParam1);

           return view;
    }
}