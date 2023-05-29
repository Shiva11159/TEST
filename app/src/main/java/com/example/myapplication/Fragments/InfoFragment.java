package com.example.myapplication.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.myapplication.MainActivity2;
import com.example.myapplication.NetworkCall.RequestInterface;
import com.example.myapplication.NetworkCall.RetrofitClientInstance;
import com.example.myapplication.R;
import com.example.myapplication.ReusableLogics.Logics;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class InfoFragment extends Fragment {
    View view;
    TextView txt_match, txt_date, txt_time, txt_toss, txt_venue, txt_umpire, txt_3rdumpire, txt_referee;


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
        view = inflater.inflate(R.layout.infofragment, container, false);

        txt_match = view.findViewById(R.id.txt_match);
        txt_date =view.findViewById(R.id.txt_date);
        txt_time = view.findViewById(R.id.txt_time);
        txt_toss = view.findViewById(R.id.txt_toss);
        txt_venue = view.findViewById(R.id.txt_venue);
        txt_umpire = view.findViewById(R.id.txt_umpire);
        txt_3rdumpire = view.findViewById(R.id.txt_3rdumpire);
        txt_referee = view.findViewById(R.id.txt_referee);

        txt_match.setText(Logics.getTeaminfoData(getActivity()).get(0));
        txt_date.setText(Logics.getTeaminfoData(getActivity()).get(1));
        txt_time.setText(Logics.getTeaminfoData(getActivity()).get(2));
        txt_toss.setText(Logics.getTeaminfoData(getActivity()).get(3));
        txt_venue.setText(Logics.getTeaminfoData(getActivity()).get(4));
        txt_umpire.setText(Logics.getTeaminfoData(getActivity()).get(5));
        txt_3rdumpire.setText(Logics.getTeaminfoData(getActivity()).get(5));
        txt_referee.setText(Logics.getTeaminfoData(getActivity()).get(7));

        return view;
    }

}


