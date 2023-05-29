package com.example.myapplication.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class UpcomingFragment extends Fragment {

    View view;

    @Override
    public void onAttach(@NonNull Context context) {

        Log.e("onAttach", "ccc ");

        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.e("onCreate", "ccc ");

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.e("onViewCreated", "ccc ");

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.e("onStart", "ccc ");

        super.onStart();
    }

    @Override
    public void onResume() {
        Log.e("onResume", "ccc ");

        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        Log.e(" ccc", "ccc ");

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.upcomingfragment, container, false);

        return view;

    }
}


