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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapters.HighlightsAdapter;
import com.example.myapplication.Adapters.TeamSquadAdapter;
import com.example.myapplication.Datasets.TeamUpdates;
import com.example.myapplication.R;
import com.example.myapplication.ReusableLogics.Logics;

import java.util.ArrayList;

public class LiveFragment extends Fragment {

    View view;
    RecyclerView recyclview;
    HighlightsAdapter highlightsAdapter;

    ArrayList<TeamUpdates>teamUpdatesArrayList;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.livefragment, container, false);
        return view;
    }
}


