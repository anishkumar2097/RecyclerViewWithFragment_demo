package com.example.recyclerviewwithfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentList#newInstance} factory method to
 * create an instance of this DetialFragment.
 */
public class FragmentList extends Fragment implements CustomAdapter.ItemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the DetialFragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
     List<String> arr=new ArrayList<>();
     RecyclerView recyclerView;
     CustomAdapter adapter;
    public FragmentList() {
        // Required empty public constructor
    }

      public  List<String>  getList() {
          for (int i = 0; i < 100; i++) {
              arr.add(new Random() + "\n\n" +"position:"+ i);
          }
           return arr;
      }      /**
             * Use this factory method to create a new instance of
             * this DetialFragment using the provided parameters.
             *
             * @param param1 Parameter 1.
             * @param param2 Parameter 2.
             * @return A new instance of DetialFragment FragmentList.
             */
                // TODO: Rename and change types and number of parameters
                public static FragmentList newInstance(String param1, String param2) {
        FragmentList fragment = new FragmentList();
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
        // Inflate the layout for this DetialFragment
        View v=inflater.inflate(R.layout.recycler_list_fragment_layout, container, false);
        recyclerView=v.findViewById(R.id.recycler_view);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        adapter=new CustomAdapter(getList(),this,getActivity());
        recyclerView.setAdapter(adapter);

        return v;
    }

    @Override
    public void OnItemClick(String msg) {
           getActivity().getSupportFragmentManager().beginTransaction()
                 .replace(R.id.fragment_containerview,DetialFragment.newInstance(msg))
                   .setReorderingAllowed(true)
                   .addToBackStack("name")
                   .commit();
    }
}