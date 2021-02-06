package com.vimal.dynamicviewpager.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


import com.vimal.dynamicviewpager.R;

public class MyFragment extends Fragment {

    int position;

    public MyFragment() {
        // Required empty public constructor
    }


    public static MyFragment newInstance(int position) {
        MyFragment fragment = new MyFragment();

        fragment.position = position;

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my, container, false);


        TextView txt =  view.findViewById(R.id.txt);
        txt.setText("Fragment "+(position+1));

        return view;
    }



    @Override
    public void onResume() {
        super.onResume();


    }
}